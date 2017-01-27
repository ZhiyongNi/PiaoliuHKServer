/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.core;

import java.sql.SQLException;

/**
 *
 * @author zhiyo
 */
public class Porter extends Admin{

    public int PorterID;
    public String PorterName;
    public String PorterPassword;
    public int PorterType;
    public String PorterMobile;
    public String PorterRealName;
    public String PorterEmail;
    public int PorterAccountStatus;
    public boolean isAuthorized;

    public void AuthPorterbyNameandPassword() throws SQLException {
        /*Porter Admin_Temp = new Porter();
        if (this.AdminName != null) {
            Admin_Temp = AdminDB.searchAdminbyAdminName(this.AdminName);
        }
        if (this.AdminPassword == null ? Admin_Temp.AdminPassword == null : this.AdminPassword.equals(Admin_Temp.AdminPassword)) {
            CloneThis(Admin_Temp);
            this.isAuthorized = true;
            Thread.currentThread().setName(Admin_Temp.AdminRealName);
        }*/
    }

    public void CloneThis(Porter f_Porter) {
        this.PorterID = f_Porter.PorterID;
        this.PorterName = f_Porter.PorterName;
        this.PorterPassword = f_Porter.PorterPassword;
        this.PorterType = f_Porter.PorterType;
        this.PorterMobile = f_Porter.PorterMobile;
        this.PorterRealName = f_Porter.PorterRealName;
        this.PorterEmail = f_Porter.PorterEmail;
        this.PorterAccountStatus = f_Porter.PorterAccountStatus;
    }
}
