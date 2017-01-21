/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.engine;

import com.piaoliuhkserver.models.core.Customer;
import com.piaoliuhkserver.models.dbengine.CustomerDB;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zhiyo
 */
public class CustomerList {

    public String ExcuteCommand;
    public ArrayList<Customer> CustomerItemList = new ArrayList<Customer>();

    public void findAllCustomerbyFilter() throws SQLException {
        //Customer Customer_Temp = new Customer();
        // if (this.AdminName != null) {
        this.CustomerItemList = CustomerDB.searchbyExcuteCommand(this.ExcuteCommand);
        // }
        if (this.CustomerItemList != null) {
            //CloneThis(Admin_Temp);
            //this.isAuthorized = true;
        }
    }
}
