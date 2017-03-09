/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.net;

import com.google.gson.Gson;
import com.piaoliuhkserver.Global;
import com.piaoliuhkserver.models.core.Admin;
import com.piaoliuhkserver.models.core.Container;
import com.piaoliuhkserver.models.core.Package;
import com.piaoliuhkserver.models.engine.CustomerList;
import com.piaoliuhkserver.models.engine.CheckoutItem;
import com.piaoliuhkserver.models.engine.PackageList;
import com.piaoliuhkserver.models.engine.ScriptCommand;
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

    public void doRequire() throws IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Gson gson = new Gson();
        Class Target_Class = Class.forName(SyncClassName.replace("PiaoliuHKOperator.Models", "com.piaoliuhkserver.models"));
        Object Target_Instance = gson.fromJson(this.SyncJsonString, Target_Class);

        Method SyncCommand_Method = Target_Instance.getClass().getDeclaredMethod(this.SyncCommand);
        SyncCommand_Method.invoke(Target_Instance);
        SyncJsonString = gson.toJson(Target_Instance);
        SyncSucceed = true;
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
