package com.tmn.account.service.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tmn.account.model.TransactionHistory;
import com.tmn.account.service.TransactionHistoryService;
import com.tmn.account.util.HibernateUtil;

/**
 *
 * @author jum
 */
public class TransactionHistoryHibernateImpl implements TransactionHistoryService {

    @Override
    public List<TransactionHistory> getAllTransactionHistory() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<TransactionHistory> TransactionHistorys = session.createQuery("from TransactionHistory").list();
        return TransactionHistorys;
    }

    @Override
    public TransactionHistory getTransactionHistoryByTransactionNumber(String transactionNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        TransactionHistory TransactionHistory = (TransactionHistory) session.load(TransactionHistory.class, code);
//        return TransactionHistory;
        String hql = "from TransactionHistory where transactionNumber = :transactionNumber";
        Query query = session.createQuery(hql);
        query.setParameter("transactionNumber",transactionNumber);
        List<TransactionHistory> cities = query.list();
        if (cities != null && cities.size() > 0) return cities.get(0); else return null;
    }

    @Override
    public void updateTransactionHistory(TransactionHistory targetTransactionHistory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(targetTransactionHistory);
        session.getTransaction().commit();
    }

    @Override
    public void removeTransactionHistory(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TransactionHistory TransactionHistory = (TransactionHistory) session.load(TransactionHistory.class, code);
        session.delete(TransactionHistory);
        session.getTransaction().commit();
    }

    @Override
    public void createTransactionHistory(TransactionHistory newTransactionHistory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(newTransactionHistory);
        session.getTransaction().commit();
    }
}
