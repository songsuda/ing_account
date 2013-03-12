/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.account.service.impl;


import java.text.ParseException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmn.account.application.hibernate.App;
import com.tmn.account.model.User;
import com.tmn.account.service.UsersService;

/**
 *
 * @author roofimon
 */
public class UserRepository {
   private static Logger logger = Logger.getLogger(UserRepository.class);
   
    private HashMap<String, User> repository;

	private ApplicationContext appContext;
    public UserRepository(){
        /*repository = new HashMap<String, User>();
        User firstUser = new User("roofimon", "password");
        User secondUser = new User("boyone", "password");
        repository.put(firstUser.getUsername(), firstUser);
        repository.put(secondUser.getUsername(), secondUser);*/
    	
    	App app = new App();
    	try {
			app.main(null);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public User getUserByUsername(String username){
//      logger.debug("Finding: "+username);
//      return this.repository.get(username);
    	 UsersService usersService = new UserHibernateImpl();
       return usersService.getUserByName(username);
         
/*    	appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    	UsersService usersService = (UsersService) appContext.getBean("classpath*:/usersService");
    	return usersService.getUserByName(username);
*/
    }
}
