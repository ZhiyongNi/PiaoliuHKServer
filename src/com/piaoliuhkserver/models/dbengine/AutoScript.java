/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.dbengine;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhiyo
 */
public class AutoScript {

    public static String TransitBillIDRepeatChecks() throws SQLException {
        ResultSet ResultSet_DB = ScripttoQuery("select * from piaoliuhk_transitbillinsys where TransitBillID in (select distinct TransitBillID from piaoliuhk_transitbillsigned);");
        int count = 0;
        while (ResultSet_DB.next()) {
            count++;
        }
        if (count == 0) {
            return "TransitBillID RepeatChecks Well.";
        } else {
            return "TransitBillID RepeatChecks Wrong.";
        }
    }

    public static String PackageIDRepeatChecks() throws SQLException {
        ResultSet ResultSet_DB = ScripttoQuery("select * from piaoliuhk_packageinsys where PackageID in (select distinct PackageID from piaoliuhk_packagesigned);");
        int count = 0;
        while (ResultSet_DB.next()) {
            count++;
        }
        if (count == 0) {
            return "PackageID RepeatChecks Well.";
        } else {
            return "PackageID RepeatChecks Wrong.";
        }
    }

    private static ResultSet ScripttoQuery(String f_ScriptString) throws SQLException {
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement(f_ScriptString);
        return PreparedStatement_DB.executeQuery();
    }

    public static String PackageRelatedTransitBillCheck(String f_TargetDB) throws SQLException {
        String Package_DBName = "";
        switch (f_TargetDB) {
            case "INSYS":
                Package_DBName = "piaoliuhk_packageinsys";
                break;
            case "SIGNED":
                Package_DBName = "piaoliuhk_packagesigned";
                break;
        }
        Connection Connect = MysqlConnect.getConnect();
        HashMap<String, ArrayList< String>> PackageRelatedTransitBillSerialID_HashMap = new HashMap();

        PreparedStatement PreparedStatement_DB = Connect.prepareStatement("SELECT PackageSerialID, PackageRelatedTransitBillSerialID FROM express_piaoliuhk." + Package_DBName + ";");
        ResultSet ResultSet_DB = PreparedStatement_DB.executeQuery();

        while (ResultSet_DB.next()) {
            String IDKey = ResultSet_DB.getString("PackageRelatedTransitBillSerialID");
            ArrayList<String> IDValue_Temp = new ArrayList<>();
            IDValue_Temp.add(ResultSet_DB.getString("PackageSerialID"));

            ArrayList< String> IDValue = PackageRelatedTransitBillSerialID_HashMap.putIfAbsent(IDKey, IDValue_Temp);
            if (IDValue != null) {
                IDValue.add(ResultSet_DB.getString("PackageSerialID"));
                PackageRelatedTransitBillSerialID_HashMap.replace(IDKey, IDValue);
            }
        }
        new Thread(() -> {
            String TransitBill_DBName = "";
            switch (f_TargetDB) {
                case "INSYS":
                    TransitBill_DBName = "piaoliuhk_transitbillinsys";
                    break;
                case "SIGNED":
                    TransitBill_DBName = "piaoliuhk_transitbillsigned";
                    break;
            }

            try {
                for (Map.Entry object : PackageRelatedTransitBillSerialID_HashMap.entrySet()) {
                    String IDKey = (String) object.getKey();
                    ArrayList<String> IDValue = (ArrayList<String>) object.getValue();

                    PreparedStatement PreparedStatement_DB_Second = Connect.prepareStatement("UPDATE express_piaoliuhk." + TransitBill_DBName + " SET TransitBillRelatedPackageSerialID='" + new Gson().toJson(IDValue, ArrayList.class) + "', TransitBillRelatedPackageQuantity = " + IDValue.size() + " WHERE TransitBillSerialID='" + IDKey + "';");
                    PreparedStatement_DB_Second.executeUpdate();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AutoScript.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();

        return "PackageRelatedTransitBillCheck Has " + PackageRelatedTransitBillSerialID_HashMap.size() + " Rows.";
    }

    public static String PendingTransitBillCheckout() throws SQLException {
        Connection Connect = MysqlConnect.getConnect();

        PreparedStatement PreparedStatement_DB = Connect.prepareStatement("UPDATE piaoliuhk_transitbillinsys SET TransitBillStatus = 7 where TransitBillStatus = 8;");
        PreparedStatement_DB.executeUpdate();

        PreparedStatement_DB = Connect.prepareStatement("UPDATE piaoliuhk_transitbillinsys INNER JOIN piaoliuhk_packageinsys ON piaoliuhk_transitbillinsys.TransitBillSerialID=piaoliuhk_packageinsys.PackageRelatedTransitBillSerialID SET piaoliuhk_transitbillinsys.TransitBillStatus = 8 where piaoliuhk_packageinsys.PackageStatus = 9;");
        PreparedStatement_DB.executeUpdate();

        ResultSet ResultSet_DB = ScripttoQuery("select * from piaoliuhk_transitbillinsys where TransitBillStatus = 7;");
        int count = 0;
        while (ResultSet_DB.next()) {
            count++;
        }

        return "TransitBillCheckout Has " + count + " Rows.";
    }

}
