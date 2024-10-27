package edu.tum.ase.servletapp;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import jakarta.servlet.http.HttpServlet;

public class ServletConfigurator {

    public void addServlet(Tomcat tomcat, Context context, String servletName, String urlPattern, HttpServlet servlet) {
        tomcat.addServlet("", servletName, servlet);
        context.addServletMappingDecoded(urlPattern, servletName);
    }
}
