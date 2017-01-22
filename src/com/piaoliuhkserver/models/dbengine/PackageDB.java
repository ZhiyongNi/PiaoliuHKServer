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

/**
 *
 * @author zhiyo
 */
public class PackageDB {

    public static Package searchPackagebyExpressTrackNumber(String f_ExpressTrackNumber) throws SQLException {
        Package Package_Return = new Package();
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement("select * from piaoliuhk_admin where AdminName = ?");
        //pstmt = (PreparedStatement) Connect.prepareStatement(sql);
        PreparedStatement_DB.setString(1, f_ExpressTrackNumber);
        ResultSet ResultSet_DB = PreparedStatement_DB.executeQuery();

        while (ResultSet_DB.next()) {
            /*Package_ReturnAdmin.AdminID = ResultSet_DB.getInt("AdminID");
            Admin_ReturnAdmin.AdminName = ResultSet_DB.getString("AdminName");
            Admin_ReturnAdmin.AdminPassword = ResultSet_DB.getString("AdminPassword");
            Admin_ReturnAdmin.AdminType = ResultSet_DB.getInt("AdminType");
            Admin_ReturnAdmin.AdminMobile = ResultSet_DB.getString("AdminMobile");
            Admin_ReturnAdmin.AdminRealName = ResultSet_DB.getString("AdminRealName");
            Admin_ReturnAdmin.AdminEmail = ResultSet_DB.getString("AdminEmail");
            Admin_ReturnAdmin.AdminAccountStatus = ResultSet_DB.getInt("AdminAccountStatus");*/
        }
        return Package_Return;
    }
}
