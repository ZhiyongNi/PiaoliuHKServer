/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.core;

import com.piaoliuhkserver.Global;
import com.piaoliuhkserver.models.dbengine.PackageDB;
import com.piaoliuhkserver.models.dbengine.TransitBillDB;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author zhiyo
 */
public class TransitBill {

    public int TransitBillID;
    public String TransitBillSerialID;
    public int TransitBillOwnerID;
    public ArrayList<String> TransitBillRelatedPackageSerialID = new ArrayList<>();
    public int TransitBillRelatedPackageQuantity;
    public float TransitBillPrice;
    public int TransitBillMethod;
    public String TransitBillAddress;
    public int TransitBillSettlement;
    public double TransitBillInitializationTimeStamp;
    public double TransitBillSignTimeStamp;
    public int TransitBillStatus;

    public ArrayList<String> TransitBillCell_Argument_List = new ArrayList<String>();

    public void updateTransitBillArgumentInfo() throws SQLException {
        HashMap Cell_Argument_HashMap = new HashMap();
        //if (!this.PackageCell_Argument_List.isEmpty()) {
        //Cell_Argument_HashMap.put("PackageSerialID", this.PackageSerialID);
        //PackageCell_Argument_List.forEach((CellString) -> {
        //    Cell_Argument_HashMap.put(CellString.split("=")[0], CellString.split("=")[1]);
        //});
        //int PackageStatus_Target = Integer.parseInt(Cell_Argument_HashMap.get("PackageStatus").toString());
        //String f_TargetDBName = JudgeDBNamebyPackageStatus(PackageStatus_Target);
        //String f_SourceDBName = JudgeDBNamebyPackageStatus(this.PackageStatus);
        //PackageDB.modifyPackagebyArgumentInfo(f_TargetDBName, f_SourceDBName, this.PackageSerialID, PackageCell_Argument_List);
    }

    public void addTransitBillNewRecoder() throws SQLException, IllegalArgumentException, IllegalAccessException {
            if (this.TransitBillSerialID.equals("TBTEMP")) {
            Global.Today_TransitBillSerialNum++;
            String SerialNumber_String = new SimpleDateFormat("yyyyMMdd").format(new Date()) + String.format("%04d", Global.Today_TransitBillSerialNum);
            TransitBillSerialID = "PA" + SerialNumber_String + SelfVerifyChar(Long.parseLong(SerialNumber_String));
        }
        TransitBillDB.addTransitBill(this);
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

    private static String JudgeDBNamebyTransitBillStatus(int f_PackageStatus) {
        String DBName = "";
        if (f_PackageStatus == 1) {
            DBName = "piaoliuhk_packagesigned";
        } else {
            DBName = "piaoliuhk_packageinsys";
        }
        return DBName;
    }

    private void CloneThis(TransitBill f_TransitBill) {
        this.TransitBillID = f_TransitBill.TransitBillID;
        this.TransitBillSerialID = f_TransitBill.TransitBillSerialID;
        this.TransitBillOwnerID = f_TransitBill.TransitBillOwnerID;
        this.TransitBillRelatedPackageSerialID = f_TransitBill.TransitBillRelatedPackageSerialID;
        this.TransitBillRelatedPackageQuantity = f_TransitBill.TransitBillRelatedPackageQuantity;
        this.TransitBillPrice = f_TransitBill.TransitBillPrice;
        this.TransitBillMethod = f_TransitBill.TransitBillMethod;
        this.TransitBillAddress = f_TransitBill.TransitBillAddress;
        this.TransitBillSettlement = f_TransitBill.TransitBillSettlement;
        this.TransitBillInitializationTimeStamp = f_TransitBill.TransitBillInitializationTimeStamp;
        this.TransitBillSignTimeStamp = f_TransitBill.TransitBillSignTimeStamp;
        this.TransitBillStatus = f_TransitBill.TransitBillStatus;
    }
}
