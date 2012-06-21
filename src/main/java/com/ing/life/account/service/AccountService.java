/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.life.account.service;

import com.ing.life.account.model.Account;
import java.util.List;

/**
 *
 * @author roofimon
 */
public interface AccountService {

    void createAccount(Account newAccount);

    Account getAccountByCode(String code);

    List<Account> getAllAccount();

    void removeAccount(String code);

    void updateAccount(Account targetAccount);
    
}
