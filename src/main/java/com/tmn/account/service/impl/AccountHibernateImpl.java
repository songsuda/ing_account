/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.account.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tmn.account.model.Account;
import com.tmn.account.service.AccountService;
import com.tmn.account.util.HibernateUtil;

/**
 *
 * @author roofimon
 */
public class AccountHibernateImpl implements AccountService {

    @Override
    public List<Account> getAllAccount() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Account> accounts = session.createQuery("from Account").list();
        return accounts;
    }

    @Override
    public Account getAccountByCode(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account account = (Account) session.load(Account.class, code);
        return account;
    }

    @Override
    public void updateAccount(Account targetAccount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(targetAccount);
        session.getTransaction().commit();
    }

    @Override
    public void removeAccount(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Account account = (Account) session.load(Account.class, code);
        session.delete(account);
        session.getTransaction().commit();
    }

    @Override
    public void createAccount(Account newAccount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(newAccount);
        session.getTransaction().commit();
    }
    
    @Override
    public Account getAccountByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Account where name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name",name);
        List<Account> cities = query.list();
        if (cities != null && cities.size() > 0) return cities.get(0); else return null;
    }

}
