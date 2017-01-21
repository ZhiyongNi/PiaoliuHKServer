/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.controls;

import com.piaoliuhkserver.models.net.OperatorSocket;
import com.piaoliuhkserver.views.gui.MainWin;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhiyo
 */
public class OperatorServer {

    public static void startOperatorServer() {
    try {
            OperatorSocket.startSocketServer();  // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(MainWin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
