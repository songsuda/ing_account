package com.tmn.account.service.impl;

import com.tmn.account.model.Account;
import com.tmn.account.service.AccountService;
import com.tmn.account.util.HibernateUtil;

import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roofimon
 * Date: 3/7/13 AD
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountSpringHibernateTemplate  implements AccountService {

    private HibernateTemplate hibernateTemplate = new HibernateTemplate(HibernateUtil.getSessionFactory());

    @Override
    public void createAccount(Account newAccount) {
        //To change body of implemented methods use File | Settings | File Templates.
		hibernateTemplate.saveOrUpdate(newAccount);
    }

    @Override
    public Account getAccountByCode(String code) {
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
		List<Account> cities = hibernateTemplate.find("from Account where code = ?", code);
        if (cities != null && cities.size() > 0) return cities.get(0); else return null;
    }

    @Override
    public List<Account> getAllAccount() {
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
        return hibernateTemplate.loadAll(Account.class);
    }

    @Override
    public void removeAccount(String code) {
        //To change body of implemented methods use File | Settings | File Templates.
    	Account account = hibernateTemplate.get(Account.class, code);
    	hibernateTemplate.delete(account);
    }

    @Override
    public void updateAccount(Account targetAccount) {
        //To change body of implemented methods use File | Settings | File Templates.
		hibernateTemplate.saveOrUpdate(targetAccount);
    }

	@Override
	public Account getAccountByName(String name) {
		// TODO Auto-generated method stub
//		return null;
		List<Account> cities = hibernateTemplate.find("from Account where name = ?", name);
        if (cities != null && cities.size() > 0) return cities.get(0); else return null;
	}
}
