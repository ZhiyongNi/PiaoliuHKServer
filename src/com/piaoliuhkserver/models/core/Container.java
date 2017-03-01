/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.core;

import com.piaoliuhkserver.models.dbengine.ContainerDB;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    private ArrayList<String> ContainerCell_Argument_List = new ArrayList<String>();

    public void addContainerNewRecoder() throws SQLException, IllegalArgumentException, IllegalAccessException {
        if (this.ContainerSerialID.equals("COTEMP")) {

            SimpleDateFormat asqw = new SimpleDateFormat("yyyyMMdd");

            ContainerSerialID = "CO" + asqw.format(new Date()) + 2;
        }

        ContainerDB.addContainer(this);
    }

    public void updateContainerRecoderbyArgumentInfo() throws SQLException {
        HashMap Cell_Argument_HashMap = new HashMap();
        //if (!this.PackageCell_Argument_List.isEmpty()) {
        Cell_Argument_HashMap.put("ContainerID", this.ContainerID);
        ContainerCell_Argument_List.forEach((CellString) -> {
            Cell_Argument_HashMap.put(CellString.split("=")[0], CellString.split("=")[1]);
        });
        int ContainerStatus_Target = Integer.parseInt(Cell_Argument_HashMap.get("ContainerStatus").toString());
        String f_TargetDBName = JudgeDBNamebyPackageStatus(ContainerStatus_Target);
        String f_SourceDBName = JudgeDBNamebyPackageStatus(this.ContainerStatus);
        ContainerDB.modifyContainerbyArgumentInfo(f_TargetDBName, f_SourceDBName, this.ContainerSerialID, ContainerCell_Argument_List);
    }

    private static String JudgeDBNamebyPackageStatus(int f_PackageStatus) {
        return "";
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
