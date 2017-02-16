/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.engine;

import com.piaoliuhkserver.models.core.Package;
import com.piaoliuhkserver.models.dbengine.PackageDB;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zhiyo
 */
public class PackageList {

    public ArrayList<String> SQLExecuteArray = new ArrayList<String>();
    public ArrayList<Package> PackageItemList = new ArrayList<Package>();

    public void findALLPackagebyFilter() throws SQLException {
        this.PackageItemList = PackageDB.findPackagebyExecuteCommand("ALL", this.SQLExecuteArray);
        if (this.PackageItemList != null) {
            //CloneThis(Admin_Temp);
            //this.isAuthorized = true;
        }
    }

    public void findSIGNEDPackagebyFilter() throws SQLException {
        this.PackageItemList = PackageDB.findPackagebyExecuteCommand("piaoliuhk_packagesigned", this.SQLExecuteArray);
        if (this.PackageItemList != null) {
            //CloneThis(Admin_Temp);
            //this.isAuthorized = true;
        }
    }

    public void findINSYSPackagebyFilter() throws SQLException {
        this.PackageItemList = PackageDB.findPackagebyExecuteCommand("piaoliuhk_packageinsys", this.SQLExecuteArray);
        // }
        if (this.PackageItemList != null) {
            //CloneThis(Admin_Temp);
            //this.isAuthorized = true;
        }
    }

    public void findUNMATCHEDPackagebyFilter() throws SQLException {
        this.PackageItemList = PackageDB.findPackagebyExecuteCommand("piaoliuhk_packageunmatched", this.SQLExecuteArray);
        if (this.PackageItemList != null) {
            //CloneThis(Admin_Temp);
            //this.isAuthorized = true;
        }
    }
}
