/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.login.entitiesbeans.user;

import com.bionic.login.entities.User;
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

    List<User> findRange(int[] range);

    int count();
    
    User findByLogin(String login);
    
}
