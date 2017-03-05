/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.core;

import com.piaoliuhkserver.Global;
import com.piaoliuhkserver.models.dbengine.ContainerDB;
import com.piaoliuhkserver.models.dbengine.PackageDB;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import jdk.nashorn.internal.parser.TokenType;
import sun.security.krb5.Confounder;

/**
 *
 * @author zhiyo
 */
public class Package {

    public int PackageID;
    public String PackageSerialID;
    public int PackageOwnerID;
    public String PackageOwnerMobile;
    public String PackageExpressCompany;
    public String PackageExpressTrackNumber;
    public String PackageSnapshot;
    public float PackageWeight;
    public float PackageFee;
    public double PackageInTimeStamp;
    public double PackageOutTimeStamp;
    public int PackageStatus;
    public String PackageRemarks;
    public int PackageWorkerID;
    public String PackageRelatedTransitBillSerialID;

    public ArrayList<String> PackageCell_Argument_List = new ArrayList<String>();

    public void updatePackageArgumentInfo() throws SQLException {
        HashMap Cell_Argument_HashMap = new HashMap();
        //if (!this.PackageCell_Argument_List.isEmpty()) {
        Cell_Argument_HashMap.put("PackageSerialID", this.PackageSerialID);
        PackageCell_Argument_List.forEach((CellString) -> {
            Cell_Argument_HashMap.put(CellString.split("=")[0].trim(), CellString.split("=")[1].trim());
        });
        int PackageStatus_Target = Integer.parseInt(Cell_Argument_HashMap.get("PackageStatus").toString().replace("\'", ""));
        String f_TargetDBName = JudgeDBNamebyPackageStatus(PackageStatus_Target);
        String f_SourceDBName = JudgeDBNamebyPackageStatus(this.PackageStatus);
        PackageDB.modifyPackagebyArgumentInfo(f_TargetDBName, f_SourceDBName, this.PackageSerialID, PackageCell_Argument_List);
    }

    public void addPackageNewRecoder() throws SQLException, IllegalArgumentException, IllegalAccessException {
        if (this.PackageSerialID.equals("PATEMP")) {
            Global.Today_PackageSerialNum++;
            String SerialNumber_String = new SimpleDateFormat("yyyyMMdd").format(new Date()) + String.format("%04d", Global.Today_PackageSerialNum);
            PackageSerialID = "PA" + SerialNumber_String + SelfVerifyChar(Long.parseLong(SerialNumber_String));
        }
        PackageDB.addPackage(this);
    }

    private static String SelfVerifyChar(long SerialNumber) {
        String VerifyChar = "";
        switch (new Long(SerialNumber % 11).intValue()) {
            case 10:
                VerifyChar = "2";
                break;
            case 9:
                VerifyChar = "3";
                break;
            case 8:
                VerifyChar = "4";
                break;
            case 7:
                VerifyChar = "5";
                break;
            case 6:
                VerifyChar = "6";
                break;
            case 5:
                VerifyChar = "7";
                break;
            case 4:
                VerifyChar = "8";
                break;
            case 3:
                VerifyChar = "9";
                break;
            case 2:
                VerifyChar = "X";
                break;
            case 1:
                VerifyChar = "0";
                break;
            case 0:
                VerifyChar = "1";
                break;
        }
        return VerifyChar;
    }

    private static String JudgeDBNamebyPackageStatus(int f_PackageStatus) {
        String DBName = "";
        if (f_PackageStatus == 1) {
            DBName = "piaoliuhk_packagesigned";
        } else {
            DBName = "piaoliuhk_packageinsys";
        }
        return DBName;
    }

    private void CloneThis(Package f_Package) {
        this.PackageID = f_Package.PackageID;
        this.PackageSerialID = f_Package.PackageSerialID;
        this.PackageOwnerID = f_Package.PackageOwnerID;
        this.PackageOwnerMobile = f_Package.PackageOwnerMobile;
        this.PackageExpressCompany = f_Package.PackageExpressCompany;
        this.PackageExpressTrackNumber = f_Package.PackageExpressTrackNumber;
        this.PackageSnapshot = f_Package.PackageSnapshot;
        this.PackageWeight = f_Package.PackageWeight;
        this.PackageFee = f_Package.PackageFee;
        this.PackageInTimeStamp = f_Package.PackageInTimeStamp;
        this.PackageOutTimeStamp = f_Package.PackageOutTimeStamp;
        this.PackageStatus = f_Package.PackageStatus;
        this.PackageRemarks = f_Package.PackageRemarks;
        this.PackageWorkerID = f_Package.PackageWorkerID;
        this.PackageRelatedTransitBillSerialID = f_Package.PackageRelatedTransitBillSerialID;
    }
}
