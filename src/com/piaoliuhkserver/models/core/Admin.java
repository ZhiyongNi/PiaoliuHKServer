/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.core;

import com.piaoliuhkserver.models.dbengine.AdminDB;
import java.sql.SQLException;

/**
 *
 * @author zhiyo
 */
public class Admin {

    public int AdminID;
    public String AdminName;
    public String AdminPassword;
    public int AdminType;
    public String AdminMobile;
    public String AdminRealName;
    public String AdminEmail;
    public int AdminAccountStatus;
    public boolean isAuthorized;

    public void AuthAdminbyNameandPassword() throws SQLException {
        Admin Admin_Temp = new Admin();
        if (this.AdminName != null) {
            Admin_Temp = AdminDB.searchAdminbyAdminName(this.AdminName);
        }
        if (this.AdminPassword == null ? Admin_Temp.AdminPassword == null : this.AdminPassword.equals(Admin_Temp.AdminPassword)) {
            CloneThis(Admin_Temp);
            this.isAuthorized = true;

        }
    }

    public void addAdminNewRecoder() {
    }

    public void CloneThis(Admin f_Admin) {
        this.AdminID = f_Admin.AdminID;
        this.AdminName = f_Admin.AdminName;
        this.AdminPassword = f_Admin.AdminPassword;
        this.AdminType = f_Admin.AdminType;
        this.AdminMobile = f_Admin.AdminMobile;
        this.AdminRealName = f_Admin.AdminRealName;
        this.AdminEmail = f_Admin.AdminEmail;
        this.AdminAccountStatus = f_Admin.AdminAccountStatus;
    }
}
