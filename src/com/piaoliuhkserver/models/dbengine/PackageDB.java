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
import java.util.Iterator;

/**
 *
 * @author zhiyo
 */
public class PackageDB {

    public static ArrayList<Package> findPackagebyExecuteCommand(String f_DBName, ArrayList f_SQLExecuteArray) throws SQLException {
        String ExecuteCommandString = "";
        Iterator Iter = f_SQLExecuteArray.iterator();
        while (Iter.hasNext()) {
            ExecuteCommandString += Iter.next();
            if (Iter.hasNext()) {
                ExecuteCommandString += " and ";
            } else {
                ExecuteCommandString = " where " + ExecuteCommandString;
            }
        }
        ExecuteCommandString += ";";
        ArrayList<Package> Package_ArrayList = new ArrayList<>();
        if ("ALL".equals(f_DBName)) {
            Package_ArrayList.addAll(ExecuteCommandinQuery("SELECT * FROM express_piaoliuhk.piaoliuhk_packagesigned" + ExecuteCommandString));
            Package_ArrayList.addAll(ExecuteCommandinQuery("SELECT * FROM express_piaoliuhk.piaoliuhk_packageinsys" + ExecuteCommandString));
            Package_ArrayList.addAll(ExecuteCommandinQuery("SELECT * FROM express_piaoliuhk.piaoliuhk_packageunmatched" + ExecuteCommandString));
        } else {
            Package_ArrayList = ExecuteCommandinQuery("SELECT * FROM express_piaoliuhk." + f_DBName + ExecuteCommandString);
        }
        return Package_ArrayList;
    }

    public static ArrayList<Package> searchINSYSPackagebyRelatedTransitBillSerialID(String f_PackageRelatedTransitBillSerialID) throws SQLException {
        String ExecuteCommandString = "SELECT * FROM express_piaoliuhk.piaoliuhk_packageinsys where PackageRelatedTransitBillSerialID = /'" + f_PackageRelatedTransitBillSerialID + "/';";
        return ExecuteCommandinQuery(ExecuteCommandString);
    }

    public static ArrayList<Package> ExecuteCommandinQuery(String f_ExecuteCommandString) throws SQLException {
        ArrayList<Package> PackageItemList = new ArrayList<>();
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement(f_ExecuteCommandString);
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

    public static int modifyPackagebyArgumentInfo(String f_TargetDBName, String f_SourceDBName, String f_PackageSerialID, ArrayList<String> f_PackageCell_Argument_List) throws SQLException {
        StringBuilder PackageCell_StringBuilder = new StringBuilder();
        //StringBuilder CellValue = new StringBuilder();
        Iterator Iter = f_PackageCell_Argument_List.iterator();
        while (Iter.hasNext()) {
            PackageCell_StringBuilder.append(Iter.next());
            if (Iter.hasNext()) {
                PackageCell_StringBuilder.append(" , ");
            }
        }
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = null;
        if (!f_TargetDBName.equals(f_SourceDBName)) {
            PreparedStatement_DB = Connect.prepareStatement("replace into " + f_TargetDBName + " (select * from " + f_SourceDBName + " where PackageSerialID = '" + f_PackageSerialID + "' );");
            PreparedStatement_DB.executeUpdate();

            PreparedStatement_DB = Connect.prepareStatement("delete from " + f_SourceDBName + " where PackageSerialID = '" + f_PackageSerialID + "' ;");
            PreparedStatement_DB.executeUpdate();
        }
        String SQLCommand = "update " + f_TargetDBName + " set " + PackageCell_StringBuilder.toString() + " where PackageSerialID = '" + f_PackageSerialID + "' ;";

        PreparedStatement_DB = Connect.prepareStatement(SQLCommand);
        //pstmt = (PreparedStatement) Connect.prepareStatement(sql);
        return PreparedStatement_DB.executeUpdate();
    }
}
