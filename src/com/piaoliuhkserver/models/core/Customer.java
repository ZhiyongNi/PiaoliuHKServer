/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author zhiyo
 */
public class Customer {

    public int CustomerID;
    public String CustomerName;
    public String CustomerPassword;
    public String CustomerRealName;
    public int CustomerGender;
    public String CustomerSelfMobile;
    public String CustomerSelfDefaultAddress;
    public String CustomerSelfDirectAddress;
    public String CustomerSelfOtherAddress;
    public String CustomerCollage;
    public String CustomerEmail;
    public String CustomerQQ;
    public String CustomerWeixin;
    public String CustomerAlipay;
    public String CustomerAvatarMobile;
    public String CustomerAvatarAddress;
    public int CustomerAccountStatus;

    public ArrayList<String> CustomerCell_Argument_List = new ArrayList<String>();

    public void updateCustomerArgumentInfo() throws SQLException {
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

    public void addCustomerNewRecoder() throws SQLException {
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

    private static String JudgeDBNamebyCustomerStatus(int f_CustomerStatus) {
        String DBName = "";
        if (f_CustomerStatus == 1) {
            DBName = "piaoliuhk_packagesigned";
        } else {
            DBName = "piaoliuhk_packageinsys";
        }
        return DBName;
    }

    private void CloneThis(Customer f_Customer) {
        this.CustomerID = f_Customer.CustomerID;
        this.CustomerName = f_Customer.CustomerName;
        this.CustomerPassword = f_Customer.CustomerPassword;
        this.CustomerRealName = f_Customer.CustomerRealName;
        this.CustomerGender = f_Customer.CustomerGender;
        this.CustomerSelfMobile = f_Customer.CustomerSelfMobile;
        this.CustomerSelfDefaultAddress = f_Customer.CustomerSelfDefaultAddress;
        this.CustomerSelfDirectAddress = f_Customer.CustomerSelfDirectAddress;
        this.CustomerSelfOtherAddress = f_Customer.CustomerSelfOtherAddress;
        this.CustomerCollage = f_Customer.CustomerCollage;
        this.CustomerEmail = f_Customer.CustomerEmail;
        this.CustomerQQ = f_Customer.CustomerQQ;
        this.CustomerWeixin = f_Customer.CustomerWeixin;
        this.CustomerAlipay = f_Customer.CustomerAlipay;
        this.CustomerAvatarMobile = f_Customer.CustomerAvatarMobile;
        this.CustomerAvatarAddress = f_Customer.CustomerAvatarAddress;
        this.CustomerAccountStatus = f_Customer.CustomerAccountStatus;
    }
}
