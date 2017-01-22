/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.net;

import com.piaoliuhkserver.Global;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhiyo
 */
public class OperatorSocket {

    public static void startSocketServer() throws IOException {
        Thread ServerSocket_Thread = new Thread(() -> {
            String LocalHost = Global.OperatorServer_LocalHost;
            Integer listenPort = Global.OperatorServer_listenPort;
            
            try {
                ServerSocket ServerSocket_Instance = new ServerSocket();
                ServerSocket_Instance.bind(new InetSocketAddress(LocalHost, listenPort));
                while (true) {
                    DialoguebySocket(ServerSocket_Instance.accept());
                }
            } catch (IOException ex) {
                Logger.getLogger(OperatorSocket.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        ServerSocket_Thread.setName("OperatorServerSocketThread");
        ServerSocket_Thread.start();
        Global.OperatorServerSocketThread = ServerSocket_Thread;
    }

    public static void endSocketServer() throws IOException, InterruptedException {
        //Global.OperatorServerSocketThread.stop();
    }

    public static void DialoguebySocket(Socket f_Socket) throws IOException {
        Thread DialogueSocket_Thread = new Thread(() -> {
            byte Delimiter = Global.SocketDelimiter;
            while (true) {
                ByteArrayOutputStream OutputStream = new ByteArrayOutputStream();
                try {
                    InputStream IS = f_Socket.getInputStream();
                    int nextByte;

                    while ((nextByte = IS.read()) != Delimiter) {
                        if (nextByte != -1) {
                            OutputStream.write(nextByte);
                        } else {//还没有读取到定界符
                            break;
                        }
                    }

                    if (OutputStream.size() != 0) {//如果读取到的流为空
                        byte[] MessageData = Base64.getDecoder().decode(OutputStream.toByteArray());
                        String SyncString = new String(MessageData, "UTF-8");

                        System.out.println(SyncString);

                        SyncClass SyncClass_Instance = new SyncClass(SyncString);
                        SyncClass_Instance.doRequire();
                        byte[] MessageReturnData = Base64.getEncoder().encode(SyncClass_Instance.doReturn());

                        DialogueSend(f_Socket, MessageReturnData);
                    } else {                    //如果读取到的流不为空，则抛出异常
                    }
                } catch (IOException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException ex) {
                    Logger.getLogger(OperatorSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        DialogueSocket_Thread.start();
        Global.OperatorDialogueSocketThreadArray.add(DialogueSocket_Thread);
    }

    public static void DialogueSend(Socket f_Socket, byte[] ReturnData) {
        try {
            OutputStream OS = f_Socket.getOutputStream();
            OS.write(ReturnData);  // Send the encoded string to the server
            OS.write(Global.SocketDelimiter);

        } catch (IOException ex) {
            Logger.getLogger(OperatorSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}