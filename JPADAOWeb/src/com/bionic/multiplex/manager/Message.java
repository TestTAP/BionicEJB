/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.multiplex.manager;

import java.util.ResourceBundle;

/**
 *
 * @author KMM
 */
public class Message {

    private static Message instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "com.bionic.login.manager.messages";
    public static final String SERVLET_EXCEPTION = "SERVLET_EXCEPTION";
    public static final String IO_EXCEPTION = "IO_EXCEPTION";
    public static final String LOGIN_ERROR = "LOGIN_ERROR";

    public static Message getInstance() {
        if (instance == null) {
            instance = new Message();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
