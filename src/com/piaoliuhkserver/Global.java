package com.piaoliuhkserver;

import com.mysql.jdbc.MySQLConnection;

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
    public static MySQLConnection[] MySQLConnectionArray;
    public static Thread[] OperatorDialogueArray;
}
