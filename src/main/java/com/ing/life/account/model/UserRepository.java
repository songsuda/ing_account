/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.life.account.model;


import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 * @author roofimon
 */
public class UserRepository {
   private static Logger logger = Logger.getLogger(UserRepository.class);
    private HashMap<String, User> repository;
    public UserRepository(){
        repository = new HashMap<String, User>();
        User firstUser = new User("roofimon", "password");
        User secondUser = new User("boyone", "password");
        repository.put(firstUser.getUsername(), firstUser);
        repository.put(secondUser.getUsername(), secondUser);
    }
    
    public User getUserByUsername(String username){
        logger.debug("Finding: "+username);
        return this.repository.get(username);
    }
}
