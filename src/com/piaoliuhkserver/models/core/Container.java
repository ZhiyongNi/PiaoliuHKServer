/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.core;

import com.piaoliuhkserver.Global;
import com.piaoliuhkserver.models.dbengine.ContainerDB;
import com.piaoliuhkserver.models.dbengine.PackageDB;
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
    public double ContainerInitializationTimeStamp;
    public double ContainerSignTimeStamp;
    public int ContainerStatus;

    private ArrayList<String> ContainerCell_Argument_List = new ArrayList<String>();

    public void addContainerNewRecoder() throws SQLException, IllegalArgumentException, IllegalAccessException {
        if (this.ContainerSerialID.equals("COTEMP")) {
            Global.Today_ContainerSerialNum++;
            String SerialNumber_String = new SimpleDateFormat("yyyyMMdd").format(new Date()) + String.format("%04d", Global.Today_ContainerSerialNum);
            ContainerSerialID = "CO" + SerialNumber_String + SelfVerifyChar(Long.parseLong(SerialNumber_String));
        }
        ContainerDB.addContainer(this);
    }

    private static String SelfVerifyChar(long SerialNumber) {
        String VerifyChar = "";
        switch (new Long(SerialNumber % 11).intValue()) {
            case 10:
                VerifyChar = "2";
                break;
            case 9:
                VerifyChar = "3";
                break;
            case 8:
                VerifyChar = "4";
                break;
            case 7:
                VerifyChar = "5";
                break;
            case 6:
                VerifyChar = "6";
                break;
            case 5:
                VerifyChar = "7";
                break;
            case 4:
                VerifyChar = "8";
                break;
            case 3:
                VerifyChar = "9";
                break;
            case 2:
                VerifyChar = "X";
                break;
            case 1:
                VerifyChar = "0";
                break;
            case 0:
                VerifyChar = "1";
                break;
        }
        return VerifyChar;
    }

    public void updateContainerRecoderbyArgumentInfo() throws SQLException {
        HashMap Cell_Argument_HashMap = new HashMap();
        //if (!this.PackageCell_Argument_List.isEmpty()) {
        Cell_Argument_HashMap.put("ContainerID", this.ContainerID);
        ContainerCell_Argument_List.forEach((CellString) -> {
            Cell_Argument_HashMap.put(CellString.split("=")[0], CellString.split("=")[1]);
        });
        int ContainerStatus_Target = Integer.parseInt(Cell_Argument_HashMap.get("ContainerStatus").toString());
        String f_TargetDBName = JudgeDBNamebyContainerStatus(ContainerStatus_Target);
        String f_SourceDBName = JudgeDBNamebyContainerStatus(this.ContainerStatus);
        ContainerDB.modifyContainerbyArgumentInfo(f_TargetDBName, f_SourceDBName, this.ContainerSerialID, ContainerCell_Argument_List);
    }

    private static String JudgeDBNamebyContainerStatus(int f_ContainerStatus) {
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
