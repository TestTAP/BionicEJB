package com.bionic.movieplex.logic.actions.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bionic.movieplex.logic.actions.ActionCommand;
import com.bionic.movieplex.logic.managers.ConfigurationManager;

public class NoCommand implements ActionCommand{
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.LOGIN_PAGE_PATH);
        return page;
    }

}