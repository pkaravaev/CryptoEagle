package com.cryptoeagle.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Blog extends BaseEntity{

    private String name;
    private String url;
    @OneToMany(mappedBy = "blog")
    private List<Item> items = new ArrayList<>();
    @ManyToOne
    private User user;


    public Blog(int id_blog, String name, String URL) {
        super(id_blog);
        this.name = name;
        this.url = URL;
    }

    public Blog( String name, String URL) {
        this.name = name;
        this.url = URL;
    }

    public Blog(){}


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public List<Item> getItems() {
        return items;
    }

    public void setItems(Item item) {
      items.add(item);
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
