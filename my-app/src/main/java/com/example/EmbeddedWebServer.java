package edu.tum.ase.servletapp;

import jakarta.servlet.http.HttpServlet;

public interface EmbeddedWebServer {
    void start() throws Exception;
    void stop() throws Exception;
    void addServlet(String name, String urlPattern, HttpServlet servlet);
}