package com.cryptoeagle.model;

public class Blog {

    private Integer id;
    private String name;
    private String url;

    public Blog(Integer id, String name, String URL) {
        this.id = id;
        this.name = name;
        this.url = URL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
