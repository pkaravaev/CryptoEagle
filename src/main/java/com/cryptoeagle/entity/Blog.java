package com.cryptoeagle.entity;

import java.util.List;

public class Blog extends BaseEntity{

    private String name;
    private String url;
    private List<Item> items;
    private User user;


    public Blog(String name, String URL) {
        this.name = name;
        this.url = URL;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "name='" + name + '\'' +
                '}';
    }
}
