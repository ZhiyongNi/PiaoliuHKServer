/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.dbengine;

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
        if (f_DBName == "ALL") {
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

    public static ArrayList<Package> searchINSYSPackagebyRelatedTransitBillSerialID(String f_PackageRelatedTransitBillSerialID) throws SQLException {
        ArrayList<Package> PackageItemList = new ArrayList<>();
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement("SELECT * FROM express_piaoliuhk.piaoliuhk_packageinsys where PackageRelatedTransitBillSerialID = ?");
        //pstmt = (PreparedStatement) Connect.prepareStatement(sql);
        PreparedStatement_DB.setString(1, f_PackageRelatedTransitBillSerialID);
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

    public static Package addPackagebyArgumentInfo(String f_PackageRelatedTransitBillSerialID) throws SQLException {
        return null;
    }
    public static Package modifyPackagebyArgumentInfo(String f_PackageRelatedTransitBillSerialID) throws SQLException {
        return null;
    }
}
