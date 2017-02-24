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
public class Container {

    public int ContainerID;
    public String ContainerSerialID;
    public int ContainerWorkerID;
    public ArrayList<String> ContainerRelatedTransitBillSerialID = new ArrayList<>();
    public int ContainerRelatedTransitBillQuantity;
    public String ContainerExpressCompany;
    public String ContainerExpressTrackNumber;
    public float ContainerPrice;
    public int ContainerInitializationTimeStamp;
    public int ContainerSignTimeStamp;
    public int ContainerStatus;

    public ArrayList<String> ContainerCell_Argument_List = new ArrayList<String>();

    public void updateContainerArgumentInfo() throws SQLException {
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

    private void CloneThis(Container f_Container) {
        this.ContainerID = f_Container.ContainerID;
        this.ContainerSerialID = f_Container.ContainerSerialID;
        this.ContainerWorkerID = f_Container.ContainerWorkerID;
        this.ContainerRelatedTransitBillSerialID = f_Container.ContainerRelatedTransitBillSerialID;
        this.ContainerRelatedTransitBillQuantity = f_Container.ContainerRelatedTransitBillQuantity;
        this.ContainerExpressCompany = f_Container.ContainerExpressCompany;
        this.ContainerExpressTrackNumber = f_Container.ContainerExpressTrackNumber;
        this.ContainerPrice = f_Container.ContainerPrice;
        this.ContainerInitializationTimeStamp = f_Container.ContainerInitializationTimeStamp;
        this.ContainerSignTimeStamp = f_Container.ContainerSignTimeStamp;
        this.ContainerStatus = f_Container.ContainerStatus;
    }
}
