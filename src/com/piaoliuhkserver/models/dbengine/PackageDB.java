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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author zhiyo
 */
public class PackageDB {

    public static ArrayList<Package> findbyExecuteCommand(String f_DBName, ArrayList f_SQLExecuteArray) throws SQLException {
        String ExecuteCommandString = "";
        if (f_DBName == "ALL") {
            f_DBName = "piaoliuhk_packagesigned";
        }
        ExecuteCommandString = "SELECT * FROM express_piaoliuhk." + f_DBName;

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
        return ExecuteCommandinQuery(ExecuteCommandString);
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

    public static int modifyPackagebyArgumentInfo(HashMap f_Argument_HashMap) throws SQLException {
        StringBuilder CellName = new StringBuilder();
        StringBuilder CellValue = new StringBuilder();

        Iterator Iter = f_Argument_HashMap.entrySet().iterator();
        while (Iter.hasNext()) {
            Map.Entry entry = (Map.Entry) Iter.next();
            CellName.append(entry.getKey());
            CellValue.append("\'").append(entry.getValue()).append("\'");
            if (Iter.hasNext()) {
                CellName.append(",");
                CellValue.append(",");
            }
        }
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement("replace into piaoliuhk_packageinsys (" + CellName.toString() + ") values (" + CellValue.toString() + ");");
        //pstmt = (PreparedStatement) Connect.prepareStatement(sql);
        return PreparedStatement_DB.executeUpdate();
    }
}
