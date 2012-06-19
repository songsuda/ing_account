/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.life.account.model;

/**
 *
 * @author roofimon
 */
public class Account {

    String code;
    String name;
    Double balance;

    public Account(String accountId, String accountName, Double balance) {
        super();
        this.code = accountId;
        this.name = accountName;
        this.balance = balance;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}