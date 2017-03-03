/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.core;

import com.piaoliuhkserver.models.dbengine.PackageDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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
    public int PackageInTimeStamp;
    public int PackageOutTimeStamp;
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
            Cell_Argument_HashMap.put(CellString.split("=")[0], CellString.split("=")[1]);
        });
        int PackageStatus_Target = Integer.parseInt(Cell_Argument_HashMap.get("PackageStatus").toString());
        String f_TargetDBName = JudgeDBNamebyPackageStatus(PackageStatus_Target);
        String f_SourceDBName = JudgeDBNamebyPackageStatus(this.PackageStatus);
        PackageDB.modifyPackagebyArgumentInfo(f_TargetDBName, f_SourceDBName, this.PackageSerialID, PackageCell_Argument_List);
    }

    public void addPackageNewRecoder() throws SQLException {
        String TargetDBName = "piaoliuhk_packageinsys";
        PackageDB.modifyPackagebyArgumentInfo(TargetDBName, null, this.PackageSerialID, PackageCell_Argument_List);
    }

    private static String JudgeDBNamebyPackageStatus(int f_PackageStatus) {
        String DBName = "";
        if (f_PackageStatus == 1) {
            DBName = "piaoliuhk_packagesigned";
        } else if (f_PackageStatus == 9) {
            DBName = "piaoliuhk_packageunmatched";
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
