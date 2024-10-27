package edu.tum.ase.servletapp;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class ServerInitializer {
    private Tomcat tomcat;

    public ServerInitializer(int port) {
        tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.getConnector();
    }

    public Context initializeContext() {
        String contextPath = "";
        String docBase = new File(".").getAbsolutePath();
        return tomcat.addContext(contextPath, docBase);
    }

    public void start() throws LifecycleException {
        tomcat.start();
        tomcat.getServer().await();
    }

    public Tomcat getTomcat() {
        return tomcat;
    }
}
