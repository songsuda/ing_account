/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.life.account.model;

import com.ing.life.account.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author roofimon
 */
public class AccountHibernate {

    public List<Account> getAllAccount() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        List<Account> accounts = session.createQuery("from Account").list();
        return accounts;
    }

    public Account getAccountByCode(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account account = (Account) session.load(Account.class, code);
        return account;
    }

    public void updateAccount(Account targetAccount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(targetAccount);
        session.getTransaction().commit();
    }
}
