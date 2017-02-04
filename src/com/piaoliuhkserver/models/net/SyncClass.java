/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.net;

import com.google.gson.Gson;
import com.piaoliuhkserver.Global;
import com.piaoliuhkserver.models.core.Admin;
import com.piaoliuhkserver.models.core.Package;
import com.piaoliuhkserver.models.engine.CustomerList;
import com.piaoliuhkserver.models.engine.DataCSV.CheckoutCSVItem;
import com.piaoliuhkserver.models.engine.PackageList;
import com.piaoliuhkserver.models.engine.TransitBillList;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Julia
 */
public class SyncClass {

    private static final byte SocketDelimiter = Global.SocketDelimiter;

    public SyncClass(String f_SyncMessageData) {
        String[] SyncMessageArray = f_SyncMessageData.split("\\|");

        this.SyncSerial = Long.parseLong(SyncMessageArray[0]);
        this.SyncClassName = SyncMessageArray[1];
        this.SyncCommand = SyncMessageArray[2];
        this.SyncJsonString = SyncMessageArray[3];

    }
    public long SyncSerial;
    public String SyncClassName;
    public String SyncCommand;
    public String SyncJsonString;
    public Boolean SyncSucceed;

    public void doRequire() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        Gson gson = new Gson();
        Method SyncCommand_Method;
        switch (this.SyncClassName) {
            case "Admin":
                Admin Admin_Instance = new Admin();
                Admin_Instance = gson.fromJson(this.SyncJsonString, Admin.class);

                SyncCommand_Method = Admin_Instance.getClass().getDeclaredMethod(this.SyncCommand);
                SyncCommand_Method.invoke(Admin_Instance);
                Admin_Instance.isAuthorized = true;
                Global.OperatorDialogueList.addElement(Admin_Instance.AdminRealName);
                Thread.currentThread().setName(Admin_Instance.AdminRealName);

                SyncJsonString = gson.toJson(Admin_Instance);
                SyncSucceed = true;
                break;
            case "Package":
                Package Package_Instance = new Package();
                Package_Instance = gson.fromJson(this.SyncJsonString, Package.class);

                SyncCommand_Method = Package_Instance.getClass().getDeclaredMethod(this.SyncCommand);
                SyncCommand_Method.invoke(Package_Instance);

                SyncJsonString = gson.toJson(Package_Instance);
                SyncSucceed = true;
                break;
            case "CustomerList":
                CustomerList CustomerList_Instance = new CustomerList();
                CustomerList_Instance = gson.fromJson(this.SyncJsonString, CustomerList.class);

                SyncCommand_Method = CustomerList_Instance.getClass().getDeclaredMethod(this.SyncCommand);
                SyncCommand_Method.invoke(CustomerList_Instance);

                SyncJsonString = gson.toJson(CustomerList_Instance);
                SyncSucceed = true;
                break;
            case "PackageList":
                PackageList PackageList_Instance = new PackageList();
                PackageList_Instance = gson.fromJson(this.SyncJsonString, PackageList.class);

                SyncCommand_Method = PackageList_Instance.getClass().getDeclaredMethod(this.SyncCommand);
                SyncCommand_Method.invoke(PackageList_Instance);

                SyncJsonString = gson.toJson(PackageList_Instance);
                SyncSucceed = true;
                break;
            case "TransitBillList":
                TransitBillList TransitBillList_Instance = new TransitBillList();
                TransitBillList_Instance = gson.fromJson(this.SyncJsonString, TransitBillList.class);

                SyncCommand_Method = TransitBillList_Instance.getClass().getDeclaredMethod(this.SyncCommand);
                SyncCommand_Method.invoke(TransitBillList_Instance);

                SyncJsonString = gson.toJson(TransitBillList_Instance);
                SyncSucceed = true;
                break;
            case "CheckoutCSVItem":
                CheckoutCSVItem CheckoutCSVItem_Instance = new CheckoutCSVItem();
                CheckoutCSVItem_Instance = gson.fromJson(this.SyncJsonString, CheckoutCSVItem.class);

                SyncCommand_Method = CheckoutCSVItem_Instance.getClass().getDeclaredMethod(this.SyncCommand);
                SyncCommand_Method.invoke(CheckoutCSVItem_Instance);

                SyncJsonString = gson.toJson(CheckoutCSVItem_Instance);
                SyncSucceed = true;
                break;
        }
    }

    public byte[] doReturn() throws UnsupportedEncodingException {
        byte[] MessageData = null;
        if (this.SyncSucceed) {
            Gson gson = new Gson();
            String MessageString = Long.toString(this.SyncSerial) + "|" + this.SyncJsonString;
            MessageData = MessageString.getBytes("UTF8");
        }
        return MessageData;
    }
}
