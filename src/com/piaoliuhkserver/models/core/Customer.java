/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.core;

/**
 *
 * @author zhiyo
 */
public class Customer {

    public int CustomerID;
    public String CustomerName;
    public String CustomerPassword;
    public String CustomerRealName;
    public int CustomerGender;
    public String CustomerSelfMobile;
    public String CustomerSelfDefaultAddress;
    public String CustomerSelfDirectAddress;
    public String CustomerSelfOtherAddress;
    public String CustomerCollage;
    public String CustomerEmail;
    public String CustomerQQ;
    public String CustomerWeixin;
    public String CustomerAlipay;
    public String CustomerAvatarMobile;
    public String CustomerAvatarAddress;
    public int CustomerAccountStatus;

    public void CloneThis(Customer f_Customer) {
        this.CustomerID = f_Customer.CustomerID;
        this.CustomerName = f_Customer.CustomerName;
        this.CustomerPassword = f_Customer.CustomerPassword;
        this.CustomerRealName = f_Customer.CustomerRealName;
        this.CustomerGender = f_Customer.CustomerGender;
        this.CustomerSelfMobile = f_Customer.CustomerSelfMobile;
        this.CustomerSelfDefaultAddress = f_Customer.CustomerSelfDefaultAddress;
        this.CustomerSelfDirectAddress = f_Customer.CustomerSelfDirectAddress;
        this.CustomerSelfOtherAddress = f_Customer.CustomerSelfOtherAddress;
        this.CustomerCollage = f_Customer.CustomerCollage;
        this.CustomerEmail = f_Customer.CustomerEmail;
        this.CustomerQQ = f_Customer.CustomerQQ;
        this.CustomerWeixin = f_Customer.CustomerWeixin;
        this.CustomerAlipay = f_Customer.CustomerAlipay;
        this.CustomerAvatarMobile = f_Customer.CustomerAvatarMobile;
        this.CustomerAvatarAddress = f_Customer.CustomerAvatarAddress;
        this.CustomerAccountStatus = f_Customer.CustomerAccountStatus;
    }
}
