/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.multiplex.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author KMM
 */
public class ServletInitializedListener implements ServletRequestListener {

    private static int counter;

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Destroy");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext context = sre.getServletContext();
        ServletRequest request = sre.getServletRequest();
        synchronized (context) {
            String name = ((HttpServletRequest) request).getRequestURI();
            System.out.println("Request= " + name + "  Counter=" + ++counter);
            context.log("Request= " + name + "  Counter=" + counter);
        }
    }
}
