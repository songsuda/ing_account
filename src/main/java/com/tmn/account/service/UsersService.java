/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.account.service;

import java.util.List;

import com.tmn.account.model.User;

/**
 *
 * @author jum
 */
public interface UsersService {

    void createUser(User newUser);

    User getUserByName(String name);

    List<User> getAllUser();

    void removeUser(String code);

    void updateUser(User targetUser);
    
}
