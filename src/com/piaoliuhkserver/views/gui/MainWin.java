/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.views.gui;

import com.piaoliuhkserver.Global;
import com.piaoliuhkserver.controls.OperatorServer;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author zhiyo
 */
public class MainWin extends javax.swing.JFrame {

    /**
     * Creates new form MainWin
     */
    public MainWin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OperatorServerSwitch_Button = new javax.swing.JToggleButton();
        OperatorServer_Label = new javax.swing.JLabel();
        OperatorDialogueThread_ScrollPane = new javax.swing.JScrollPane();
        OperatorDialogueThread_List = new javax.swing.JList<>();
        LocalDBSwitch_Button = new javax.swing.JToggleButton();
        RemoteDBSwitch_Button = new javax.swing.JToggleButton();
        LocalDB_Label = new javax.swing.JLabel();
        RemoteDB_Label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        File_Menu = new javax.swing.JMenu();
        Edit_Menu = new javax.swing.JMenu();
        Function_Menu = new javax.swing.JMenu();
        OperatorServerSetting_MenuItem = new javax.swing.JMenuItem();
        OperatorServerSwitch_MenuItem = new javax.swing.JMenuItem();
        DB_Menu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OperatorServerSwitch_Button.setText("On/Off");
        OperatorServerSwitch_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorServerSwitch_ButtonActionPerformed(evt);
            }
        });

        OperatorServer_Label.setText("OperatorServer");

        OperatorDialogueThread_ScrollPane.setViewportView(OperatorDialogueThread_List);

        LocalDBSwitch_Button.setText("On/Off");
        LocalDBSwitch_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalDBSwitch_ButtonActionPerformed(evt);
            }
        });

        RemoteDBSwitch_Button.setText("On/Off");
        RemoteDBSwitch_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoteDBSwitch_ButtonActionPerformed(evt);
            }
        });

        LocalDB_Label.setText("本地数据库连接");

        RemoteDB_Label.setText("远程数据库连接");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        File_Menu.setText("文件");
        jMenuBar1.add(File_Menu);

        Edit_Menu.setText("编辑");
        jMenuBar1.add(Edit_Menu);

        Function_Menu.setText("功能");

        OperatorServerSetting_MenuItem.setText("OperatorServer配置");
        OperatorServerSetting_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorServerSetting_MenuItemActionPerformed(evt);
            }
        });
        Function_Menu.add(OperatorServerSetting_MenuItem);

        OperatorServerSwitch_MenuItem.setText("开启／关闭OperatorServer");
        OperatorServerSwitch_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorServerSwitch_MenuItemActionPerformed(evt);
            }
        });
        Function_Menu.add(OperatorServerSwitch_MenuItem);

        jMenuBar1.add(Function_Menu);

        DB_Menu.setLabel("数据库");

        jMenuItem2.setText("本地数据库配置");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        DB_Menu.add(jMenuItem2);

        jMenuItem3.setText("开启／关闭本地数据库");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        DB_Menu.add(jMenuItem3);

        jMenuItem4.setText("远程数据库配置");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        DB_Menu.add(jMenuItem4);

        jMenuItem5.setText("开启／关闭远程数据库");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        DB_Menu.add(jMenuItem5);

        jMenuBar1.add(DB_Menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(OperatorServerSwitch_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OperatorServer_Label)
                                .addGap(106, 106, 106)
                                .addComponent(LocalDBSwitch_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(OperatorDialogueThread_ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RemoteDBSwitch_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LocalDB_Label)
                            .addComponent(RemoteDB_Label))
                        .addContainerGap(57, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OperatorServer_Label)
                    .addComponent(OperatorServerSwitch_Button)
                    .addComponent(LocalDBSwitch_Button)
                    .addComponent(LocalDB_Label))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RemoteDBSwitch_Button)
                            .addComponent(RemoteDB_Label)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OperatorDialogueThread_ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OperatorServerSetting_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OperatorServerSetting_MenuItemActionPerformed
        // TODO add your handling code here:
        OperatorServerSetting_Frame OperatorServerSetting_Frame_Instance = new OperatorServerSetting_Frame();
        OperatorServerSetting_Frame_Instance.show();

    }//GEN-LAST:event_OperatorServerSetting_MenuItemActionPerformed

    private void OperatorServerSwitch_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OperatorServerSwitch_ButtonActionPerformed
        if (OperatorServerSwitch_Button.isSelected()) {
            //System.out.println("com.piao");
            OperatorServer.startOperatorServer();
        } else {
            OperatorServer.endOperatorServer();
        }
        OperatorDialogueThread_List.setModel(Global.OperatorDialogueList);
    }//GEN-LAST:event_OperatorServerSwitch_ButtonActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void OperatorServerSwitch_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OperatorServerSwitch_MenuItemActionPerformed
        // TODO add your handling code here:
        OperatorServer.startOperatorServer();
    }//GEN-LAST:event_OperatorServerSwitch_MenuItemActionPerformed

    private void LocalDBSwitch_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalDBSwitch_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocalDBSwitch_ButtonActionPerformed

    private void RemoteDBSwitch_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoteDBSwitch_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoteDBSwitch_ButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu DB_Menu;
    private javax.swing.JMenu Edit_Menu;
    private javax.swing.JMenu File_Menu;
    private javax.swing.JMenu Function_Menu;
    private javax.swing.JToggleButton LocalDBSwitch_Button;
    private javax.swing.JLabel LocalDB_Label;
    private javax.swing.JList<String> OperatorDialogueThread_List;
    private javax.swing.JScrollPane OperatorDialogueThread_ScrollPane;
    private javax.swing.JMenuItem OperatorServerSetting_MenuItem;
    private javax.swing.JToggleButton OperatorServerSwitch_Button;
    private javax.swing.JMenuItem OperatorServerSwitch_MenuItem;
    private javax.swing.JLabel OperatorServer_Label;
    private javax.swing.JToggleButton RemoteDBSwitch_Button;
    private javax.swing.JLabel RemoteDB_Label;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
