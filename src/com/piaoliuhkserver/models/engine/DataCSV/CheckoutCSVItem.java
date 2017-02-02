/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.engine.DataCSV;

import com.piaoliuhkserver.models.core.Customer;
import com.piaoliuhkserver.models.dbengine.CustomerDB;
import com.piaoliuhkserver.models.core.Package;
import com.piaoliuhkserver.models.dbengine.PackageDB;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zhiyo
 */
public class CheckoutCSVItem {

    public String TransitBillSerialID;
    public int TransitBillOwnerID;

    public class CustomerInfo {

        public String CustomerRealName;
        public String CustomerSelfMobile;
    }

    public class PackageInfo {

        public String PackageSerialID;
        public float PackageWeight;
    }

    public ArrayList<CustomerInfo> CustomerInfo_List;
    public ArrayList<PackageInfo> PackageInfo_List;
    public int TransitBillRelatedPackageQuantity;
    public float TransitBillPrice;
    public String TransitBillAddress;

    public void CompleteSelfInfo() throws SQLException {
        CustomerInfo_List = new ArrayList<CustomerInfo>();
        PackageInfo_List = new ArrayList<PackageInfo>();
        Customer Customer_Temp = new Customer();
        if (this.TransitBillOwnerID != 0) {
            Customer_Temp = CustomerDB.searchCustomerbyCustomerID(this.TransitBillOwnerID);
            CustomerInfo asas = new CustomerInfo();
            asas.CustomerRealName = Customer_Temp.CustomerRealName;
            asas.CustomerSelfMobile = Customer_Temp.CustomerSelfMobile;
            CustomerInfo_List.add(asas);
            String a = "";
        }

        /*Package Package_Temp = new Package();
        if (this.TransitBillOwnerID != 0) {
            Package_Temp = PackageDB.searchPackagebyRelatedTransitBillSerialID(this.TransitBillSerialID);
            this.CustomerRealName = Customer_Temp.CustomerRealName;
            this.CustomerSelfMobile = Customer_Temp.CustomerSelfMobile;
        }*/
    }

    public void CloneThis(CheckoutCSVItem f_CheckoutCSVItem) {
        this.TransitBillSerialID = f_CheckoutCSVItem.TransitBillSerialID;
        this.TransitBillOwnerID = f_CheckoutCSVItem.TransitBillOwnerID;
        //this.CustomerRealName = f_CheckoutCSVItem.CustomerRealName;
        //this.CustomerSelfMobile = f_CheckoutCSVItem.CustomerSelfMobile;
        //this.TransitBillRelatedPackageSerialID_List = f_CheckoutCSVItem.TransitBillRelatedPackageSerialID_List;
        //this.PackageWeight_List = f_CheckoutCSVItem.PackageWeight_List;
        this.TransitBillRelatedPackageQuantity = f_CheckoutCSVItem.TransitBillRelatedPackageQuantity;
        this.TransitBillPrice = f_CheckoutCSVItem.TransitBillPrice;
        this.TransitBillAddress = f_CheckoutCSVItem.TransitBillAddress;
    }
}
