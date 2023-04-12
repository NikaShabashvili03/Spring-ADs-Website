package com.shabashvili.Web.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Post {


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private  Long id;

    private String title, anons, text;
    private int views;


    public Post(){}
    public Post(String title, String anons, String text) {
        this.title = title;
        this.anons = anons;
        this.text = text;
    }
}
