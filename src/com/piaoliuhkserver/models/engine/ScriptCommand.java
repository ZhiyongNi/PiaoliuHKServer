/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.engine;

import com.piaoliuhkserver.models.dbengine.AutoScript;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zhiyo
 */
public class ScriptCommand {

    public ArrayList<String> ResultReturnList = new ArrayList<String>();

    public void IDRepeatChecks() throws SQLException {
        this.ResultReturnList.add(AutoScript.PackageIDRepeatChecks());
        this.ResultReturnList.add(AutoScript.TransitBillIDRepeatChecks());
    }

    public void INSYSPackageRelatedTransitBillCheck() throws SQLException {
        this.ResultReturnList.add(AutoScript.PackageRelatedTransitBillCheck("INSYS"));
    }

    public void SIGNEDPackageRelatedTransitBillCheck() throws SQLException {
        this.ResultReturnList.add(AutoScript.PackageRelatedTransitBillCheck("SIGNED"));
    }

    public void PendingtoCheckoutTransitBill() throws SQLException {
        this.ResultReturnList.add(AutoScript.PendingTransitBillCheckout());
    }
}
