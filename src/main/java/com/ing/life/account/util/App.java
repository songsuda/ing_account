/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.life.account.util;

import com.ing.life.account.model.Account;
import com.ing.life.account.model.TransactionHistory;
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
        
        TransactionHistory firstTransaction = new TransactionHistory(new SimpleDateFormat("MM/dd/yy").parse("05/18/12"), new Double(10), "001");
        TransactionHistory secondTransaction = new TransactionHistory(new Date(), new Double(5), "002");
        TreeSet history = new TreeSet();
        history.add(firstTransaction);
        history.add(secondTransaction);
        
        newAccount.setTransactionHistory(history);
        //newAccount.getTransactionHistory().add(firstTransaction);
        //newAccount.getTransactionHistory().add(secondTransaction);
        
        System.out.println("Before Save: "+newAccount.getTransactionHistory().size());

        
        Account newnewAccount = new Account();
        newnewAccount.setCode("6677889900");
        newnewAccount.setName("manon");
        newnewAccount.setBalance(new Double(100));
        
        
        
        session.save(newAccount);
        session.save(newnewAccount);
        
        session.getTransaction().commit();
    }
}
