/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.login.servlet;

import com.bionic.login.commands.CommandLogin;
import com.bionic.login.commands.CommandMissing;
//import com.bionic.login.commands.CommandOrder;
import com.bionic.login.commands.ICommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author KMM
 */
public class ControllerHelper {

    private static ControllerHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    public ControllerHelper() {
        commands.put("login", new CommandLogin());
//        commands.put("order", new CommandOrder());
    }

    public ICommand getCommand(HttpServletRequest request) {
        ICommand command = commands.get(request.getParameter("command"));
        if (command == null) {
            command = new CommandMissing();
        }
        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
