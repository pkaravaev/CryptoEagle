package com.cryptoeagle.entity;

import java.util.Date;

public class Item {

    private Integer id;
    private String title;
    private String description;
    private Date publishDate;
    private String link;
    private Blog blog;

    public Item(Integer id, String title, String description, Date publishDate, String link) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.link = link;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
