/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.life.account.controller;

import com.ing.life.account.model.Account;
import com.ing.life.account.model.AccountHibernate;
import com.ing.life.account.model.AccountJdbc;
import com.ing.life.account.model.AccountRepository;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author roofimon
 */
@WebServlet(name = "ListAllAccount", urlPatterns = {"/ListAllAccount"})
public class ListAllAccount extends HttpServlet {
    private static Logger logger = Logger.getLogger(ListAllAccount.class);

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub        
        logger.info("Start Fetch All Acclount in ListAllAccount");
        AccountRepository accountRepo = new AccountRepository();
        //AccountJdbc accountRDBMS = new AccountJdbc();
        AccountHibernate accountHibernate = new AccountHibernate();
        List<Account> allAccount = null;
        /*try {
            allAccount = accountRDBMS.getAllAccount();
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }*/
        allAccount = accountHibernate.getAllAccount();
        // = accountRepo.getAllAccount();
        request.setAttribute("allAccount", allAccount);
        logger.debug("Account Size: "+allAccount.size());
        String nextJSP = "/listAllAccount.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}
