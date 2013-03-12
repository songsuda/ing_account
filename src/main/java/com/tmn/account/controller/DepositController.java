/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.account.controller;

import com.tmn.account.enumerates.TransactionType;
import com.tmn.account.model.Account;
import com.tmn.account.model.TransactionHistory;
import com.tmn.account.service.AccountService;
import com.tmn.account.service.impl.AccountHibernateImpl;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author roofimon
 */
@WebServlet(name = "DepositController", urlPatterns = {"/DepositController"})
public class DepositController extends HttpServlet {

    private static Logger logger = Logger.getLogger(DepositController.class);

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        String amountString = request.getParameter("amount");
		String commandType = request.getParameter("command_type");
        Double amount = Double.valueOf(amountString==null||amountString.length()==0?"0":amountString);
        
        System.out.println("OOOOOOOOOOOOOOOOO " + commandType);
//        AccountService accountService = new AccountHibernateImpl();
        ApplicationContext beanFactory = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        AccountService accountService = (AccountService)beanFactory.getBean("accountService");//new AccountHibernateImpl();

        
        Account account = accountService.getAccountByCode(code);
//        TransactionHistory newTransaction = new TransactionHistory(new Date(System.currentTimeMillis()), amount, TransactionType.DEPOSIT);
        TransactionHistory newTransaction = new TransactionHistory(new Date(System.currentTimeMillis()), amount, TransactionType.valueOf(commandType));
        account.addTransactionHistory(newTransaction);
        
        logger.debug("Account: "+account.getCode()+", Current Balance:"+account.getBalance().toString() + ", Command Type:" + TransactionType.valueOf(commandType).name());
        if (commandType.equalsIgnoreCase(TransactionType.WITHDRAW.name()))
        	account.withdraw(amount);
        else account.deposit(amount);
        logger.debug("Account: "+account.getCode()+" Current Balance:"+account.getBalance().toString());
        
        accountService.updateAccount(account);
        request.setAttribute("account", account);
        String nextJSP = "/accountInfo.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         AccountService accountService = new AccountHibernateImpl();
        //processRequest(request, response);
        String code = request.getParameter("code");
		String commandType = request.getParameter("command_type");
        Account account = accountService.getAccountByCode(code);
        
        logger.debug("Target Account:"+account.getTransactionHistory().size());
        
        request.setAttribute("code", code);
        request.setAttribute("account", account);
        request.setAttribute("command_type", commandType);
        String nextJSP = "/deposit.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);        
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
