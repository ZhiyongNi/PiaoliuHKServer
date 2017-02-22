/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.dbengine;

import com.google.gson.Gson;
import com.piaoliuhkserver.models.core.Package;
import com.piaoliuhkserver.models.core.TransitBill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zhiyo
 */
public class TransitBillDB {

    public static ArrayList<TransitBill> findbyExecuteCommand(String f_DBName, ArrayList f_SQLExecuteArray) throws SQLException {
        ArrayList<TransitBill> TransitBillItemList = new ArrayList<TransitBill>();
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement(parsetoSQL("find", f_DBName, f_SQLExecuteArray));
        //pstmt = (PreparedStatement) Connect.prepareStatement(sql);
        //PreparedStatement_DB.setString(1, f_ExcuteCommand);
        ResultSet ResultSet_DB = PreparedStatement_DB.executeQuery();

        while (ResultSet_DB.next()) {
            TransitBill TransitBill_Temp = new TransitBill();
            TransitBill_Temp.TransitBillID = ResultSet_DB.getInt("TransitBillID");
            TransitBill_Temp.TransitBillSerialID = ResultSet_DB.getString("TransitBillSerialID");
            TransitBill_Temp.TransitBillOwnerID = ResultSet_DB.getInt("TransitBillOwnerID");
            TransitBill_Temp.TransitBillRelatedPackageSerialID = new Gson().fromJson(ResultSet_DB.getString("TransitBillRelatedPackageSerialID"), ArrayList.class);
            TransitBill_Temp.TransitBillRelatedPackageQuantity = ResultSet_DB.getInt("TransitBillRelatedPackageQuantity");
            TransitBill_Temp.TransitBillPrice = ResultSet_DB.getFloat("TransitBillPrice");
            TransitBill_Temp.TransitBillMethod = ResultSet_DB.getInt("TransitBillMethod");
            TransitBill_Temp.TransitBillAddress = ResultSet_DB.getString("TransitBillAddress");
            TransitBill_Temp.TransitBillSettlement = ResultSet_DB.getInt("TransitBillSettlement");
            TransitBill_Temp.TransitBillInitializationTimeStamp = ResultSet_DB.getInt("TransitBillInitializationTimeStamp");
            TransitBill_Temp.TransitBillSignTimeStamp = ResultSet_DB.getInt("TransitBillSignTimeStamp");
            TransitBill_Temp.TransitBillStatus = ResultSet_DB.getInt("TransitBillStatus");

            TransitBillItemList.add(TransitBill_Temp);
        }
        return TransitBillItemList;
    }

    private static String parsetoSQL(String f_SQLExcuteCommand, String f_DBName, ArrayList f_SQLExcuteArray) {
        String SQLString = "";
        if (f_DBName == "All") {
            f_DBName = "piaoliuhk_transitbillsigned";
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
}
