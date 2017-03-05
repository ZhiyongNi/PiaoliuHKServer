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

    public static String OperatorServer_LocalHost = "0.0.0.0";
    //public static String OperatorServer_LocalHost = "192.168.31.142";

    public static Integer OperatorServer_listenPort = 20000;
    public static byte SocketDelimiter = '\n';
    public static byte SyncDelimiter = '|';
    public static Thread OperatorServerSocketThread;
    public static boolean OperatorSocketServerThreadFlag = false;
    public static DefaultListModel OperatorDialogueList = new DefaultListModel();
    public static MySQLConnection[] MySQLConnectionArray;

    //public static ArrayList<Thread> OperatorDialogueSocketThreadArray = new ArrayList<>();
    public static class TransitBillStatus {

        static int Signed = 1;
        static String SignedChinese = "已签收";
        static int Pickingup = 2;
        static String PickingupChinese = "派件中";
        static int Loading = 3;
        static String LoadingChinese = "已装车";
        static int Scheduling = 4;
        static String SchedulingChinese = "正安排出库";
        static int Checkin = 5;
        static String CheckinChinese = "待香港收包";
        static int inCustoms = 6;
        static String inCustomsChinese = "海关清关中";
        static int Checkout = 7;
        static String CheckoutChinese = "待深圳库出包";
        static int Pending = 8;
        static String PendingChinese = "待配齐";
    }
    
      public static int Today_PackageSerialNum;
      public static int Today_TransitBillSerialNum;
      public static int Today_ContainerSerialNum;
}
