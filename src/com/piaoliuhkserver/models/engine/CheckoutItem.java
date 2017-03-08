/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.engine;

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
public class CheckoutItem {

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

    public void FillupSelfInfo() throws SQLException {
        CustomerInfo_List = new ArrayList<CustomerInfo>();
        PackageInfo_List = new ArrayList<PackageInfo>();
        if (this.TransitBillOwnerID != 0) {
            for (Customer Customer_Temp : CustomerDB.searchCustomerbyCustomerID(this.TransitBillOwnerID)) {
                CustomerInfo CustomerInfo_Temp = new CustomerInfo();
                CustomerInfo_Temp.CustomerRealName = Customer_Temp.CustomerRealName;
                CustomerInfo_Temp.CustomerSelfMobile = Customer_Temp.CustomerSelfMobile;
                CustomerInfo_List.add(CustomerInfo_Temp);
            }
        }
        if (this.TransitBillSerialID != "") {
            for (Package Package_Temp : PackageDB.searchINSYSPackagebyRelatedTransitBillSerialID(this.TransitBillSerialID)) {
                PackageInfo PackageInfo_Temp = new PackageInfo();
                PackageInfo_Temp.PackageSerialID = Package_Temp.PackageSerialID;
                PackageInfo_Temp.PackageWeight = Package_Temp.PackageWeight;
                PackageInfo_List.add(PackageInfo_Temp);
            }
        }
    }

    public void CloneThis(CheckoutItem f_CheckoutItem) {
        this.TransitBillSerialID = f_CheckoutItem.TransitBillSerialID;
        this.TransitBillOwnerID = f_CheckoutItem.TransitBillOwnerID;
        this.CustomerInfo_List = f_CheckoutItem.CustomerInfo_List;
        this.PackageInfo_List = f_CheckoutItem.PackageInfo_List;
        this.TransitBillRelatedPackageQuantity = f_CheckoutItem.TransitBillRelatedPackageQuantity;
        this.TransitBillPrice = f_CheckoutItem.TransitBillPrice;
        this.TransitBillAddress = f_CheckoutItem.TransitBillAddress;
    }
}
