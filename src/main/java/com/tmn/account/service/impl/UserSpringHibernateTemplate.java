package com.tmn.account.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tmn.account.model.Account;
import com.tmn.account.model.User;
import com.tmn.account.service.UsersService;
import com.tmn.account.util.HibernateUtil;

public class UserSpringHibernateTemplate implements UsersService {

    private HibernateTemplate hibernateTemplate = new HibernateTemplate(HibernateUtil.getSessionFactory());

	@Override
	public void createUser(User newUser) {
		hibernateTemplate.saveOrUpdate(newUser);
	}

	@Override
	public User getUserByName(String username) {
		List<User> cities = hibernateTemplate.find("from User where username = ?", username);
        if (cities != null && cities.size() > 0) return cities.get(0); else return null;
	}

	@Override
	public List<User> getAllUser() {
        return hibernateTemplate.loadAll(User.class);
	}

	@Override
	public void removeUser(String username) {
		User user = hibernateTemplate.get(User.class, username);
    	hibernateTemplate.delete(user);
	}

	@Override
	public void updateUser(User targetUser) {
		hibernateTemplate.saveOrUpdate(targetUser);
	}

}
