package edu.tum.ase.servletapp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletApplication {

    public static void main(String[] args) throws Exception {
        EmbeddedWebServer server = new TomcatEmbeddedWebServer(8082); // or new JettyEmbeddedWebServer(8082);

        // Create an HTTP servlet for "Hello World"
        HttpServlet httpServlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                PrintWriter printWriter = resp.getWriter();
                printWriter.println("<html><head><title>Hello World</title></head><body>");
                printWriter.println("<h1>Hello World</h1>");
                printWriter.println("</body></html>");
            }
        };

        // Add servlet to server
        server.addServlet("HelloWorldServlet", "/*", httpServlet);

        // Start server
        server.start();
    }
}
