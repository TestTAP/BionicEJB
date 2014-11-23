/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.multiplex.entitiesbeans.user;

import com.bionic.multiplex.entities.User;

import java.util.List;

import javax.ejb.Local;

/**
 *
 * @author Artem
 */
@Local
public interface UserFacadeLocal {

    void create(User users);

    void edit(User users);

    void remove(User users);

    User find(Object id);

    List<User> findAll();
    
    User findByLogin(String login);
    
}
