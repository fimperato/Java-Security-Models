package it.imperato.test.security.components.impl;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterListener implements HttpSessionListener {

    private static int activeUsers;

    public static int getActiveUsers(){
        return activeUsers;
    }

//    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        activeUsers++;
    }

//    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        activeUsers--;
    }
}
