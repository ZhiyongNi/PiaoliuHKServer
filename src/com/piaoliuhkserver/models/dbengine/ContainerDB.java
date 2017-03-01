/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.dbengine;

import com.google.gson.Gson;
import com.piaoliuhkserver.models.core.Container;
import com.piaoliuhkserver.models.core.Container;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author zhiyo
 */
public class ContainerDB {

    public static ArrayList<Container> findContainerbyExecuteCommand(String f_DBName, ArrayList f_SQLExecuteArray) throws SQLException {
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
        ArrayList<Container> Container_ArrayList = new ArrayList<>();
        if ("ALL".equals(f_DBName)) {
            Container_ArrayList.addAll(ExecuteCommandinQuery("SELECT * FROM express_piaoliuhk.piaoliuhk_packagesigned" + ExecuteCommandString));
            Container_ArrayList.addAll(ExecuteCommandinQuery("SELECT * FROM express_piaoliuhk.piaoliuhk_packageinsys" + ExecuteCommandString));
        } else {
            Container_ArrayList = ExecuteCommandinQuery("SELECT * FROM express_piaoliuhk." + f_DBName + ExecuteCommandString);
        }
        return Container_ArrayList;
    }

    public static ArrayList<Container> searchINSYSContainerbyRelatedTransitBillSerialID(String f_ContainerRelatedTransitBillSerialID) throws SQLException {
        String ExecuteCommandString = "SELECT * FROM express_piaoliuhk.piaoliuhk_packageinsys where ContainerRelatedTransitBillSerialID = /'" + f_ContainerRelatedTransitBillSerialID + "/';";
        return ExecuteCommandinQuery(ExecuteCommandString);
    }

    public static ArrayList<Container> ExecuteCommandinQuery(String f_ExecuteCommandString) throws SQLException {
        ArrayList<Container> ContainerItemList = new ArrayList<>();
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement(f_ExecuteCommandString);
        ResultSet ResultSet_DB = PreparedStatement_DB.executeQuery();

        while (ResultSet_DB.next()) {
            Container Container_Temp = new Container();
            Container_Temp.ContainerID = ResultSet_DB.getInt("ContainerID");
            Container_Temp.ContainerSerialID = ResultSet_DB.getString("ContainerSerialID");
            Container_Temp.ContainerWorkerID = ResultSet_DB.getInt("ContainerWorkerID");
            Container_Temp.ContainerRelatedTransitBillSerialID = new Gson().fromJson(ResultSet_DB.getString("ContainerRelatedTransitBillSerialID"), ArrayList.class);
            Container_Temp.ContainerRelatedTransitBillQuantity = ResultSet_DB.getInt("ContainerRelatedTransitBillQuantity");
            Container_Temp.ContainerExpressCompany = ResultSet_DB.getString("ContainerExpressCompany");
            Container_Temp.ContainerExpressTrackNumber = ResultSet_DB.getString("ContainerExpressTrackNumber");
            Container_Temp.ContainerPrice = ResultSet_DB.getFloat("ContainerPrice");
            Container_Temp.ContainerInitializationTimeStamp = ResultSet_DB.getInt("ContainerInitializationTimeStamp");
            Container_Temp.ContainerSignTimeStamp = ResultSet_DB.getInt("ContainerSignTimeStamp");
            Container_Temp.ContainerStatus = ResultSet_DB.getInt("ContainerStatus");

            ContainerItemList.add(Container_Temp);
        }
        return ContainerItemList;
    }

    public static int modifyContainerbyArgumentInfo(String f_TargetDBName, String f_SourceDBName, String f_ContainerSerialID, ArrayList<String> f_ContainerCell_Argument_List) throws SQLException {
        StringBuilder ContainerCell_StringBuilder = new StringBuilder();
        //StringBuilder CellValue = new StringBuilder();
        Iterator Iter = f_ContainerCell_Argument_List.iterator();
        while (Iter.hasNext()) {
            ContainerCell_StringBuilder.append(Iter.next());
            if (Iter.hasNext()) {
                ContainerCell_StringBuilder.append(" , ");
            }
        }
        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = null;
        if (!f_TargetDBName.equals(f_SourceDBName)) {
            PreparedStatement_DB = Connect.prepareStatement("replace into " + f_TargetDBName + " (select * from " + f_SourceDBName + " where ContainerSerialID = '" + f_ContainerSerialID + "' );");
            PreparedStatement_DB.executeUpdate();

            PreparedStatement_DB = Connect.prepareStatement("delete from " + f_SourceDBName + " where ContainerSerialID = '" + f_ContainerSerialID + "' ;");
            PreparedStatement_DB.executeUpdate();
        }
        String SQLCommand = "update " + f_TargetDBName + " set " + ContainerCell_StringBuilder.toString() + " where ContainerSerialID = '" + f_ContainerSerialID + "' ;";

        PreparedStatement_DB = Connect.prepareStatement(SQLCommand);
        //pstmt = (PreparedStatement) Connect.prepareStatement(sql);
        return PreparedStatement_DB.executeUpdate();
    }

    public static int addContainer(Container f_Container) throws SQLException, IllegalArgumentException, IllegalAccessException {
        StringBuilder CellName = new StringBuilder();
        StringBuilder CellValue = new StringBuilder();
        List<Field> Field_List = Arrays.asList(f_Container.getClass().getFields());
        Iterator Iter = Field_List.iterator();
        while (Iter.hasNext()) {
            Field field = (Field) Iter.next();
            switch (field.getName()) {
                case "ContainerID":
                    break;
                case "ContainerSerialID":
                    CellName.append(field.getName());
                    CellValue.append("'").append(field.get(f_Container)).append("'");
                    break;
                case "ContainerWorkerID":
                    CellName.append(field.getName());
                    CellValue.append("'").append(field.get(f_Container)).append("'");
                    break;
                case "ContainerRelatedTransitBillSerialID":
                    CellName.append(field.getName());
                    CellValue.append("'").append(new Gson().toJson(field.get(f_Container), ArrayList.class)).append("'");
                    break;
                case "ContainerRelatedTransitBillQuantity":
                    CellName.append(field.getName());
                    CellValue.append("'").append(field.get(f_Container)).append("'");
                    break;
                case "ContainerExpressCompany":
                    CellName.append(field.getName());
                    CellValue.append("'").append(field.get(f_Container)).append("'");
                    break;
                case "ContainerExpressTrackNumber":
                    CellName.append(field.getName());
                    CellValue.append("'").append(field.get(f_Container)).append("'");
                    break;
                case "ContainerPrice":
                    CellName.append(field.getName());
                    CellValue.append("'").append(field.get(f_Container)).append("'");
                    break;
                case "ContainerInitializationTimeStamp":
                    CellName.append(field.getName());
                    CellValue.append("'").append(field.get(f_Container)).append("'");
                    break;
                case "ContainerSignTimeStamp":
                    CellName.append(field.getName());
                    CellValue.append("'").append(field.get(f_Container)).append("'");
                    break;
                case "ContainerStatus":
                    CellName.append(field.getName());
                    CellValue.append("'").append(field.get(f_Container)).append("'");
                    break;
            }
            if (Iter.hasNext() && CellName.length() != 0) {
                CellName.append(",");
                CellValue.append(",");
            }
        }

        Connection Connect = MysqlConnect.getConnect();
        PreparedStatement PreparedStatement_DB = Connect.prepareStatement("insert into piaoliuhk_containerinsys ( " + CellName.toString() + " ) values ( " + CellValue.toString() + " );");

        //pstmt = (PreparedStatement) Connect.prepareStatement(sql);
        return PreparedStatement_DB.executeUpdate();
    }
}
