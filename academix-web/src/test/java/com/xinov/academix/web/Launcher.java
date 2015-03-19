package com.xinov.academix.web;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;

import javax.naming.NamingException;

public class Launcher {

    public static void main(String[] args) throws NamingException {

        Server jettyServer=null;
        try {
            jettyServer = new Server();

            SocketConnector conn = new SocketConnector();
            conn.setPort(7501);

            jettyServer.setConnectors(new Connector[]{conn});

            WebAppContext context = new WebAppContext();
            context.setServer(jettyServer);
            context.setWar("src/main/webapp");
            context.setContextPath("/academix-web");
                        
            jettyServer.setHandler(context);

            jettyServer.start();
            jettyServer.join();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
