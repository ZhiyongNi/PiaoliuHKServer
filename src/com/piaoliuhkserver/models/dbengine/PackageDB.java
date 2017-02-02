/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.dbengine;

import com.piaoliuhkserver.models.core.Customer;
import com.piaoliuhkserver.models.core.Package;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zhiyo
 */
public class PackageDB {

    public static ArrayList<Package> findbyExecuteCommand(String f_DBName, ArrayList f_SQLExecuteArray) throws SQLException {
        ArrayList<Package> PackageItemList = new ArrayList<>();
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement(parsetoSQL("find", f_DBName, f_SQLExecuteArray));
        //pstmt = (PreparedStatement) Connect.prepareStatement(sql);
        //PreparedStatement_DB.setString(1, f_SQLExcuteJson);
        ResultSet ResultSet_DB = PreparedStatement_DB.executeQuery();

        while (ResultSet_DB.next()) {
            Package Package_Temp = new Package();
            Package_Temp.PackageID = ResultSet_DB.getInt("PackageID");
            Package_Temp.PackageSerialID = ResultSet_DB.getString("PackageSerialID");
            Package_Temp.PackageOwnerID = ResultSet_DB.getInt("PackageOwnerID");
            Package_Temp.PackageOwnerMobile = ResultSet_DB.getString("PackageOwnerMobile");
            Package_Temp.PackageExpressCompany = ResultSet_DB.getString("PackageExpressCompany");
            Package_Temp.PackageExpressTrackNumber = ResultSet_DB.getString("PackageExpressTrackNumber");
            Package_Temp.PackageSnapshot = ResultSet_DB.getString("PackageSnapshot");
            Package_Temp.PackageWeight = ResultSet_DB.getFloat("PackageWeight");
            Package_Temp.PackageFee = ResultSet_DB.getFloat("PackageFee");
            Package_Temp.PackageInTimeStamp = ResultSet_DB.getInt("PackageInTimeStamp");
            Package_Temp.PackageOutTimeStamp = ResultSet_DB.getInt("PackageOutTimeStamp");
            Package_Temp.PackageStatus = ResultSet_DB.getInt("PackageStatus");
            Package_Temp.PackageRemarks = ResultSet_DB.getString("PackageRemarks");
            Package_Temp.PackageWorkerID = ResultSet_DB.getInt("PackageWorkerID");
            Package_Temp.PackageRelatedTransitBillSerialID = ResultSet_DB.getString("PackageRelatedTransitBillSerialID");

            PackageItemList.add(Package_Temp);
        }
        return PackageItemList;
    }

    private static String parsetoSQL(String f_SQLExcuteCommand, String f_DBName, ArrayList f_SQLExcuteArray) {
        String SQLString = "";
        if (f_DBName == "All") {
            f_DBName = "piaoliuhk_packagesigned";
        }
        switch (f_SQLExcuteCommand) {
            case "find":
                SQLString = "SELECT * FROM express_piaoliuhk." + f_DBName;
                break;
        }

        if (f_SQLExcuteArray.isEmpty()) {
            SQLString += ";";
        } else {
            int i = 0;
            SQLString += " where " + f_SQLExcuteArray.get(i);
            for (i = 1; i < f_SQLExcuteArray.size(); i++) {
                SQLString += " and " + f_SQLExcuteArray.get(i);
            }
            SQLString += ";";
        }
        return SQLString;
    }

    public static Package searchPackagebyRelatedTransitBillSerialID(String f_CustomerID) throws SQLException {
        Package Package_ReturnPackage = new Package();
        /*Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement("SELECT * FROM express_piaoliuhk.piaoliuhk_customer where CustomerID = ?");
        //pstmt = (PreparedStatement) Connect.prepareStatement(sql);
        PreparedStatement_DB.setInt(1, f_CustomerID);
        ResultSet ResultSet_DB = PreparedStatement_DB.executeQuery();

        while (ResultSet_DB.next()) {
            Customer_ReturnCustomer.CustomerID = ResultSet_DB.getInt("CustomerID");
            Customer_ReturnCustomer.CustomerName = ResultSet_DB.getString("CustomerName");
            Customer_ReturnCustomer.CustomerPassword = ResultSet_DB.getString("CustomerPassword");
            Customer_ReturnCustomer.CustomerRealName = ResultSet_DB.getString("CustomerRealName");
            Customer_ReturnCustomer.CustomerGender = ResultSet_DB.getInt("CustomerGender");
            Customer_ReturnCustomer.CustomerSelfMobile = ResultSet_DB.getString("CustomerSelfMobile");
            Customer_ReturnCustomer.CustomerSelfDefaultAddress = ResultSet_DB.getString("CustomerSelfDefaultAddress");
            Customer_ReturnCustomer.CustomerSelfDirectAddress = ResultSet_DB.getString("CustomerSelfDirectAddress");
            Customer_ReturnCustomer.CustomerSelfOtherAddress = ResultSet_DB.getString("CustomerSelfOtherAddress");
            Customer_ReturnCustomer.CustomerCollage = ResultSet_DB.getString("CustomerCollage");
            Customer_ReturnCustomer.CustomerEmail = ResultSet_DB.getString("CustomerEmail");
            Customer_ReturnCustomer.CustomerQQ = ResultSet_DB.getString("CustomerQQ");
            Customer_ReturnCustomer.CustomerWeixin = ResultSet_DB.getString("CustomerWeixin");
            Customer_ReturnCustomer.CustomerAlipay = ResultSet_DB.getString("CustomerAlipay");
            Customer_ReturnCustomer.CustomerAvatarMobile = ResultSet_DB.getString("CustomerAvatarMobile");
            Customer_ReturnCustomer.CustomerAvatarAddress = ResultSet_DB.getString("CustomerAvatarAddress");
            Customer_ReturnCustomer.CustomerAccountStatus = ResultSet_DB.getInt("CustomerAccountStatus");
        }*/
        return Package_ReturnPackage;
    }
}
