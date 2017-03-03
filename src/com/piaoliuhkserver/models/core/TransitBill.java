/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author zhiyo
 */
public class TransitBill {

    public int TransitBillID;
    public String TransitBillSerialID;
    public int TransitBillOwnerID;
    public ArrayList<String> TransitBillRelatedPackageSerialID = new ArrayList<>();
    public int TransitBillRelatedPackageQuantity;
    public float TransitBillPrice;
    public int TransitBillMethod;
    public String TransitBillAddress;
    public int TransitBillSettlement;
    public int TransitBillInitializationTimeStamp;
    public int TransitBillSignTimeStamp;
    public int TransitBillStatus;

    public ArrayList<String> TransitBillCell_Argument_List = new ArrayList<String>();

    public void updateTransitBillArgumentInfo() throws SQLException {
        HashMap Cell_Argument_HashMap = new HashMap();
        //if (!this.PackageCell_Argument_List.isEmpty()) {
        //Cell_Argument_HashMap.put("PackageSerialID", this.PackageSerialID);
        //PackageCell_Argument_List.forEach((CellString) -> {
        //    Cell_Argument_HashMap.put(CellString.split("=")[0], CellString.split("=")[1]);
        //});
        //int PackageStatus_Target = Integer.parseInt(Cell_Argument_HashMap.get("PackageStatus").toString());
        //String f_TargetDBName = JudgeDBNamebyPackageStatus(PackageStatus_Target);
        //String f_SourceDBName = JudgeDBNamebyPackageStatus(this.PackageStatus);
        //PackageDB.modifyPackagebyArgumentInfo(f_TargetDBName, f_SourceDBName, this.PackageSerialID, PackageCell_Argument_List);
    }

    public void addTransitBillNewRecoder() throws SQLException {
    }

    private void CloneThis(TransitBill f_TransitBill) {
        this.TransitBillID = f_TransitBill.TransitBillID;
        this.TransitBillSerialID = f_TransitBill.TransitBillSerialID;
        this.TransitBillOwnerID = f_TransitBill.TransitBillOwnerID;
        this.TransitBillRelatedPackageSerialID = f_TransitBill.TransitBillRelatedPackageSerialID;
        this.TransitBillRelatedPackageQuantity = f_TransitBill.TransitBillRelatedPackageQuantity;
        this.TransitBillPrice = f_TransitBill.TransitBillPrice;
        this.TransitBillMethod = f_TransitBill.TransitBillMethod;
        this.TransitBillAddress = f_TransitBill.TransitBillAddress;
        this.TransitBillSettlement = f_TransitBill.TransitBillSettlement;
        this.TransitBillInitializationTimeStamp = f_TransitBill.TransitBillInitializationTimeStamp;
        this.TransitBillSignTimeStamp = f_TransitBill.TransitBillSignTimeStamp;
        this.TransitBillStatus = f_TransitBill.TransitBillStatus;
    }
}
