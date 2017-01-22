/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.engine;

import com.piaoliuhkserver.models.core.Package;
import com.piaoliuhkserver.models.dbengine.CustomerDB;
import com.piaoliuhkserver.models.dbengine.PackageDB;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zhiyo
 */
public class PackageList {

    public String ExcuteCommand;
    public ArrayList<Package> PackageItemList = new ArrayList<Package>();

    public void findAllPackagebyFilter() throws SQLException {
        //Customer Customer_Temp = new Customer();
        // if (this.AdminName != null) {
        this.PackageItemList = PackageDB.findbyExcuteCommand(this.ExcuteCommand);
        // }
        if (this.PackageItemList != null) {
            //CloneThis(Admin_Temp);
            //this.isAuthorized = true;
        }
    }
}
