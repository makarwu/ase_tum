package edu.tum.ase.servletapp;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import jakarta.servlet.http.HttpServlet;

public class TomcatEmbeddedWebServer implements EmbeddedWebServer {
    private final Tomcat tomcat;

    public TomcatEmbeddedWebServer(int port) {
        this.tomcat = new Tomcat();
        this.tomcat.setPort(port);
    }

    @Override
    public void start() throws LifecycleException {
        tomcat.getConnector();
        tomcat.start();
        tomcat.getServer().await();
    }

    @Override
    public void stop() throws LifecycleException {
        tomcat.stop();
    }

    @Override
    public void addServlet(String name, String urlPattern, HttpServlet servlet) {
        String contextPath = "";
        String docBase = new File(".").getAbsolutePath();
        Context context = tomcat.addContext(contextPath, docBase);
        tomcat.addServlet(contextPath, name, servlet);
        context.addServletMappingDecoded(urlPattern, name);
    }
}
