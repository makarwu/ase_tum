package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GreetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/xml");
        //Greeting greeting = new Greeting(1, "You joined the guestbook!", "Bob", LocalDate.now());
        List<Greeting> greetings = Arrays.asList(
        new Greeting(1, "Welcome to the guestbook!", "Bob", LocalDate.now()),
        new Greeting(2, "You joined the guestbook!", "Alice", LocalDate.now()));
        /*  try (PrintWriter writer = response.getWriter()) {
            writer.println("<greeting>");
            writer.println("    <id>" + greeting.getId() + "</id>");
            writer.println("    <content>" + greeting.getContent() + "</content>");
            writer.println("    <author>" + greeting.getAuthor() + "</author>");
            writer.println("    <date>" + greeting.getDate() + "</date>");
            writer.println("</greeting>");
        }*/
        try (PrintWriter writer = response.getWriter()){
            writer.println("<guestbook>");
            for (Greeting greeting : greetings) {
                writer.println(convertGreetingToXML(greeting));
            }
            writer.println("</guestbook>");
        }
    }

    private String convertGreetingToXML(Greeting greeting) {
        return String.format(
            "<greeting>" + 
            "   <id>%d</id>" + 
            "   <content>%s</content>" +
            "   <author>%s</author>" +
            "   <date>%s</date>" +
            "</greeting>",
            greeting.getId(),
            greeting.getContent(),
            greeting.getAuthor(),
            greeting.getDate()
        );
    }
}
