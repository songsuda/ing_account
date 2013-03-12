
package com.tmn.account.service.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tmn.account.model.User;
import com.tmn.account.service.UsersService;
import com.tmn.account.util.HibernateUtil;

/**
 *
 * @author jum
 */
public class UserHibernateImpl implements UsersService {

	private HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
/*	@Override
	public User getUserByName(String name) {
		List<User> cities = hibernateTemplate.find("from User where username = ?", name);
        if (cities != null && cities.size() > 0) return cities.get(0); else return null;
	}
*/
	@Override
    public List<User> getAllUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> User = session.createQuery("from User").list();
        return User;
    }

    @Override
    public User getUserByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        User users = (User) session.load(User.class, name);
//        return users;
        String hql = "from User where username = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name",name);
        List<User> cities = query.list();
        if (cities != null && cities.size() > 0) return cities.get(0); else return null;
    }

    @Override
    public void updateUser(User targetUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(targetUser);
        session.getTransaction().commit();
    }

    @Override
    public void removeUser(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User User = (User) session.load(User.class, code);
        session.delete(User);
        session.getTransaction().commit();
    }

    @Override
    public void createUser(User newUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(newUser);
        session.getTransaction().commit();
    }
}
