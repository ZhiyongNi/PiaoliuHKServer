package com.piaoliuhkserver;

import com.mysql.jdbc.MySQLConnection;
import java.util.ArrayList;

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

    public static String OperatorServer_LocalHost = "127.0.0.1";
    //public static String OperatorServer_LocalHost = "192.168.31.249";

    public static Integer OperatorServer_listenPort = 20000;
    public static byte SocketDelimiter = '\n';
    public static byte SyncDelimiter = '|';
    public static Thread OperatorServerSocketThread;

    public static MySQLConnection[] MySQLConnectionArray;
    public static ArrayList<Thread> OperatorDialogueSocketThreadArray = new ArrayList<>();
}