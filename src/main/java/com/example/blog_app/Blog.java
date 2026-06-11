package com.example.blog_app;

public class Blog {
    private  String title;
    private  Long id;
    private  String text;


    public Blog(String title, Long id, String text){
        this.title = title;
        this.id = id;
        this.text = text;
    }
    public Blog(){
        
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
