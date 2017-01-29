package com.piaoliuhkserver;

import com.mysql.jdbc.MySQLConnection;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zhiyo
 */
public class Global {

    //public static String OperatorServer_LocalHost = "127.0.0.1";
    public static String OperatorServer_LocalHost = "192.168.31.142";

    public static Integer OperatorServer_listenPort = 20000;
    public static byte SocketDelimiter = '\n';
    public static byte SyncDelimiter = '|';
    public static Thread OperatorServerSocketThread;
    public static boolean OperatorSocketServerThreadFlag = false;
    public static DefaultListModel OperatorDialogueList = new DefaultListModel();
    public static MySQLConnection[] MySQLConnectionArray;

    //public static ArrayList<Thread> OperatorDialogueSocketThreadArray = new ArrayList<>();
    class PiaoliuHK_Configs_GlobalConstant_TransitBillStatus {

        final int Signed = 1;
        final String SignedChinese = "已签收";
        final int inShip = 2;
        final String inShipChinese = "在途";
        final int Checkout = 3;
        final String CheckoutChinese = "需出库";
        final int Pending = 4;
        final String PendingChinese = "待配齐";
    }
}
