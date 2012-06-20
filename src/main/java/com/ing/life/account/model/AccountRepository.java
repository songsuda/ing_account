/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.life.account.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author roofimon
 */
public class AccountRepository {

    private static Logger logger = Logger.getLogger(AccountRepository.class);
    
    private HashMap<String, Account> repository;

    public AccountRepository() {
        repository = new HashMap<String, Account>();
        Account firstAccount = new Account("1122334455", "Twin Panichsombat", 500.00);
        Account secondAccount = new Account("6677889900", "Twin Panichsombat", 500.00);
        repository.put(firstAccount.getCode(), firstAccount);
        repository.put(secondAccount.getCode(), secondAccount);
    }

    public Account getAccountById(String accountId) {
        return repository.get(accountId);
    }

    public void addNewAccount(Account newAccount) {
        repository.put(newAccount.code, newAccount);
    }

    public void updateAccount(Account targetAccount) {
        repository.put(targetAccount.code, targetAccount);
    }

    public void removeAccount(String accountId) {
        repository.remove(accountId);
    }

    public List<Account> getAllAccount() {
        logger.info("this is a sample log message.");
        return new ArrayList<Account>(repository.values());
    }
}
