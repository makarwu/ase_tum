package edu.tum.ase.servletapp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import jakarta.servlet.http.HttpServlet;

public class JettyEmbeddedWebServer implements EmbeddedWebServer {
    private final Server server;
    private final ServletContextHandler context;

    public JettyEmbeddedWebServer(int port) {
        this.server = new Server(port);
        this.context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
    }

    @Override
    public void start() throws Exception {
        server.start();
        server.join();
    }

    @Override
    public void stop() throws Exception {
        server.stop();
    }

    @Override
    public void addServlet(String name, String urlPattern, HttpServlet servlet) {
        context.addServlet(servlet.getClass(), urlPattern).setName(name);
    }
}
