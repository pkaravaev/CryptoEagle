package com.cryptoeagle.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Blog extends BaseEntity  {

    private String name;
    private String url;
    @OneToMany(mappedBy = "blog", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)

    private AppUser appUser;


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


    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
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
