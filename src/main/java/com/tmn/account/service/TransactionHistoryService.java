/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.account.service;

import java.util.List;

import com.tmn.account.model.TransactionHistory;

/**
 *
 * @author jum
 */
public interface TransactionHistoryService {

    void createTransactionHistory(TransactionHistory newTransactionHistory);

    TransactionHistory getTransactionHistoryByTransactionNumber(String transactionNumber);

    List<TransactionHistory> getAllTransactionHistory();

    void removeTransactionHistory(String code);

    void updateTransactionHistory(TransactionHistory targetTransactionHistory);
    
}
