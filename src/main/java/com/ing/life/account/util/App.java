/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.life.account.util;

import com.ing.life.account.model.Account;
import org.hibernate.Session;

/**
 *
 * @author roofimon
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Account newAccount = new Account();

        newAccount.setCode("mock");
        newAccount.setName("mock name");
        newAccount.setBalance(new Double(100));

        session.save(newAccount);
        session.getTransaction().commit();
    }
}
