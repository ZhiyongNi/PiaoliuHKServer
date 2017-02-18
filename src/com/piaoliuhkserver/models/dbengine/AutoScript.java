/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.dbengine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author zhiyo
 */
public class AutoScript {

    public static ResultSet ScripttoQuery(String f_ScriptString) throws SQLException {
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement(f_ScriptString);
        return PreparedStatement_DB.executeQuery();
    }
}
