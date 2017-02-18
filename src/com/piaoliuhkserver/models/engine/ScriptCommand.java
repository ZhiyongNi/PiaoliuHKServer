/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.engine;

import com.piaoliuhkserver.models.dbengine.AutoScript;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zhiyo
 */
public class ScriptCommand {

    public ArrayList<String> ResultReturnList = new ArrayList<String>();

    public void IDRepeatChecks() throws SQLException {
        ResultSet wqResultSet = AutoScript.ScripttoQuery("select * from piaoliuhk_packageinsys where PackageID in (select distinct PackageID from piaoliuhk_packagesigned);");
        int count = 0;
        while (wqResultSet.next()) {
            count++;
        }
        if (count == 0) {
            this.ResultReturnList.add("PackageID RepeatChecks Well.");
        }

        ResultSet aqResultSet = AutoScript.ScripttoQuery("select * from piaoliuhk_transitbillinsys where TransitBillID in (select distinct TransitBillID from piaoliuhk_transitbillsigned);");
        while (aqResultSet.next()) {
            count++;
        }
        if (count == 0) {
            this.ResultReturnList.add("TransitBillID RepeatChecks Well.");
        }
    }

    public void TransitBillCheckout() {
        this.ResultReturnList.add("");
    }
}
