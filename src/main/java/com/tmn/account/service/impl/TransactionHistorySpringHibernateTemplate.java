package com.tmn.account.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tmn.account.model.TransactionHistory;
import com.tmn.account.service.TransactionHistoryService;
import com.tmn.account.util.HibernateUtil;

public class TransactionHistorySpringHibernateTemplate implements
		TransactionHistoryService {

	private HibernateTemplate hibernateTemplate = new HibernateTemplate(HibernateUtil.getSessionFactory());

	@Override
	public void createTransactionHistory(
			TransactionHistory newTransactionHistory) {
		hibernateTemplate.saveOrUpdate(newTransactionHistory);

	}

	@Override
	public TransactionHistory getTransactionHistoryByTransactionNumber(
			String transactionNumber) {
		return hibernateTemplate.get(TransactionHistory.class, transactionNumber);
	}

	@Override
	public List<TransactionHistory> getAllTransactionHistory() {
        return hibernateTemplate.loadAll(TransactionHistory.class);
	}

	@Override
	public void removeTransactionHistory(String code) {
		TransactionHistory transactionHistory = hibernateTemplate.get(TransactionHistory.class, code);
    	hibernateTemplate.delete(transactionHistory);
	}

	@Override
	public void updateTransactionHistory(
			TransactionHistory targetTransactionHistory) {
		hibernateTemplate.saveOrUpdate(targetTransactionHistory);
	}

}
