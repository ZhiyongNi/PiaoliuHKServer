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
import java.util.List;

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

    public void searchPackagebyPackageExpressTrackNumber() throws SQLException {
        Package Package_Temp = new Package();
        if (this.PackageExpressTrackNumber != null) {
            //Package_Temp = PackageDB.findbyExcuteCommand(this.PackageExpressTrackNumber);
        }
        if (this.PackageID != 0) {
            CloneThis(Package_Temp);
            //this.isAuthorized = true;
        }
    }

    public void updatePackageArgumentInfo() throws SQLException {
        Package Package_Temp = new Package();
        if (this.PackageCell_Argument_List.size() != 0) {
            HashMap Cell_Argument_HashMap = new HashMap();
            for (String CellString : PackageCell_Argument_List) {
                Cell_Argument_HashMap.put(CellString.split("=")[0], CellString.split("=")[1]);
            }
            PackageDB.addPackagebyArgumentInfo(Cell_Argument_HashMap);
            //Package_Temp = PackageDB.findbyExcuteCommand(this.PackageExpressTrackNumber);
        }
        if (this.PackageID != 0) {
            CloneThis(Package_Temp);
            //this.isAuthorized = true;
        }
    }

    public void CloneThis(Package f_Package) {
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
