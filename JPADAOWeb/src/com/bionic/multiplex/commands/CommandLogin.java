/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.multiplex.commands;

import com.bionic.multiplex.entities.User;
import com.bionic.multiplex.entitiesbeans.user.UserFacadeLocal;
import com.bionic.multiplex.manager.Config;
import com.bionic.multiplex.manager.Message;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@EJB(name = "UsersFacadeLoc", beanInterface = UserFacadeLocal.class)  
public class CommandLogin implements ICommand {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    private UserFacadeLocal userEJB = null;
//    @EJB
//    public UsersFacadeLocal userEJB;
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
      
        userEJB = lookupUsersFacadeLocal();
        
        String page = null;
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        
        User user = userEJB.findByLogin(login);
        if (user != null && user.getUserPassword().equals(password)) {
            request.setAttribute("user", login);
            page = Config.getInstance().getProperty(Config.MAIN);
        } else {
            request.setAttribute("error", Message.getInstance().getProperty(Message.LOGIN_ERROR));
            page = Config.getInstance().getProperty(Config.ERROR);
        }

        return page;
    }

    private UserFacadeLocal lookupUsersFacadeLocal() {
        try {
            Context c =new InitialContext();
            return (UserFacadeLocal)c.lookup("java:comp/env/UsersFacadeLoc");
        } catch (NamingException ex) {
            Logger.getLogger(CommandLogin.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
}
