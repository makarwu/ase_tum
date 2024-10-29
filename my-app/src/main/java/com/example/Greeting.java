package com.example;

// WEEK 2)
import java.time.LocalDate;

public class Greeting {
    private int id;
    private String content;
    private String author;
    private LocalDate date;

    public Greeting(int id, String content, String author, LocalDate date){
        this.id = id;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

}
