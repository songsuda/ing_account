package com.ing.life.account.service.impl;

import com.ing.life.account.model.Account;
import com.ing.life.account.service.AccountService;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roofimon
 * Date: 3/7/13 AD
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountSpringHibernateTemplate  implements AccountService {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void createAccount(Account newAccount) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Account getAccountByCode(String code) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Account> getAllAccount() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeAccount(String code) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateAccount(Account targetAccount) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
