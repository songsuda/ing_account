/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.account.application.hibernate;

import com.tmn.account.enumerates.TransactionType;
import com.tmn.account.model.Account;
import com.tmn.account.model.TransactionHistory;
import com.tmn.account.model.User;
import com.tmn.account.util.HibernateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.hibernate.Session;

/**
 *
 * @author roofimon
 */
public class App {

    public static void main(String[] args) throws ParseException {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        
        Calendar cal1 = new GregorianCalendar(2008, 01, 01);
       
        session.beginTransaction();
        Account newAccount = new Account();

        
        newAccount.setCode("1122334455");
        newAccount.setName("roofimon");
        newAccount.setBalance(new Double(100));
        
        TransactionHistory firstTransaction = new TransactionHistory(new SimpleDateFormat("MM/dd/yy").parse("05/18/12"), new Double(10), TransactionType.DEPOSIT);
        TransactionHistory secondTransaction = new TransactionHistory(new Date(), new Double(5), TransactionType.TRANSFER);
        TransactionHistory thirdTransaction = new TransactionHistory(new SimpleDateFormat("MM/dd/yy").parse("05/19/12"), new Double(10), TransactionType.WITHDRAW);
       
        newAccount.getTransactionHistory().add(firstTransaction);
        newAccount.getTransactionHistory().add(secondTransaction);
        newAccount.getTransactionHistory().add(thirdTransaction);
        
        System.out.println("Before Save: "+newAccount.getTransactionHistory().size());

        
        Account newnewAccount = new Account();
        newnewAccount.setCode("6677889900");
        newnewAccount.setName("manon");
        newnewAccount.setBalance(new Double(100));
        
        session.save(newAccount);
        session.save(newnewAccount);
        
        //create user
        User newUser1 = new User("roofimon", "password");
        User newUser2 = new User("boyone", "password");
        User newUser3 = new User("manon", "password");
        
        session.save(newUser1);
        session.save(newUser2);
        session.save(newUser3);
        
        session.getTransaction().commit();
    }
}
