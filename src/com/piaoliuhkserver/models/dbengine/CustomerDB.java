/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.dbengine;

import com.piaoliuhkserver.models.core.Admin;
import com.piaoliuhkserver.models.core.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zhiyo
 */
public class CustomerDB {

    public static ArrayList<Customer> findbyExcuteCommand(String f_ExcuteCommand) throws SQLException {
        ArrayList<Customer> CustomerItemList = new ArrayList<Customer>();
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement("SELECT * FROM express_piaoliuhk.piaoliuhk_customer " + f_ExcuteCommand);
        //pstmt = (PreparedStatement) Connect.prepareStatement(sql);
        //PreparedStatement_DB.setObject(1, f_ExcuteCommand);
        ResultSet ResultSet_DB = PreparedStatement_DB.executeQuery();

        while (ResultSet_DB.next()) {
            Customer Customer_Temp = new Customer();
            Customer_Temp.CustomerID = ResultSet_DB.getInt("CustomerID");
            Customer_Temp.CustomerName = ResultSet_DB.getString("CustomerName");
            Customer_Temp.CustomerPassword = ResultSet_DB.getString("CustomerPassword");
            Customer_Temp.CustomerRealName = ResultSet_DB.getString("CustomerRealName");
            Customer_Temp.CustomerGender = ResultSet_DB.getInt("CustomerGender");
            Customer_Temp.CustomerSelfMobile = ResultSet_DB.getString("CustomerSelfMobile");
            Customer_Temp.CustomerSelfDefaultAddress = ResultSet_DB.getString("CustomerSelfDefaultAddress");
            Customer_Temp.CustomerSelfDirectAddress = ResultSet_DB.getString("CustomerSelfDirectAddress");
            Customer_Temp.CustomerSelfOtherAddress = ResultSet_DB.getString("CustomerSelfOtherAddress");
            Customer_Temp.CustomerCollage = ResultSet_DB.getString("CustomerCollage");
            Customer_Temp.CustomerEmail = ResultSet_DB.getString("CustomerMail");
            Customer_Temp.CustomerQQ = ResultSet_DB.getString("CustomerQQ");
            Customer_Temp.CustomerWeixin = ResultSet_DB.getString("CustomerWeixin");
            Customer_Temp.CustomerAlipay = ResultSet_DB.getString("CustomerAlipay");
            Customer_Temp.CustomerAvatarMobile = ResultSet_DB.getString("CustomerAvatarMobile");
            Customer_Temp.CustomerAvatarAddress = ResultSet_DB.getString("CustomerAvatarAddress");
            Customer_Temp.CustomerAccountStatus = ResultSet_DB.getInt("CustomerAccountStatus");

            CustomerItemList.add(Customer_Temp);
        }
        return CustomerItemList;
    }
}
