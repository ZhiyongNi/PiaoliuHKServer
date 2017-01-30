/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.engine;

import com.piaoliuhkserver.models.core.TransitBill;
import com.piaoliuhkserver.models.dbengine.TransitBillDB;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zhiyo
 */
public class TransitBillList {

    public ArrayList<String> SQLExecuteArray = new ArrayList<String>();
    public ArrayList<TransitBill> TransitBillItemList = new ArrayList<TransitBill>();

    public void findAllTransitBillbyFilter() throws SQLException {
        //Customer Customer_Temp = new Customer();
        // if (this.AdminName != null) {
        this.TransitBillItemList = TransitBillDB.findbyExecuteCommand("ALL", this.SQLExecuteArray);
        // }
        if (this.TransitBillItemList != null) {
            //CloneThis(Admin_Temp);
            //this.isAuthorized = true;
        }
    }

    public void findSIGNEDTransitBillbyFilter() throws SQLException {
        //Customer Customer_Temp = new Customer();
        // if (this.AdminName != null) {
        this.TransitBillItemList = TransitBillDB.findbyExecuteCommand("piaoliuhk_transitbillsigned", this.SQLExecuteArray);
        // }
        if (this.TransitBillItemList != null) {
            //CloneThis(Admin_Temp);
            //this.isAuthorized = true;
        }
    }

    public void findINSYSTransitBillbyFilter() throws SQLException {
        //Customer Customer_Temp = new Customer();
        // if (this.AdminName != null) {
        this.TransitBillItemList = TransitBillDB.findbyExecuteCommand("piaoliuhk_transitbillinsys", this.SQLExecuteArray);
        // }
        if (this.TransitBillItemList != null) {
            //CloneThis(Admin_Temp);
            //this.isAuthorized = true;
        }
    }
}
