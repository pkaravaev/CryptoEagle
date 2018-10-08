package com.cryptoeagle.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = Blog.GET_ALL_BY_USER, query = "SELECT blog FROM Blog blog WHERE blog.user.id =:user_id"),
        @NamedQuery(name = Blog.GET_ALL, query = "SELECT blog FROM Blog blog"),
        @NamedQuery(name = Blog.GET_BY_NAME, query = "SELECT blog FROM Blog blog where blog.name =: name"),
        @NamedQuery(name = Blog.DELETE, query = "DELETE FROM Blog blog WHERE blog.id =:blog_id AND blog.user.id =: user_id"),
        @NamedQuery(name = Blog.DELETE_BY_NAME, query = "DELETE FROM Blog blog WHERE blog.name = :blogName"),
        @NamedQuery(name = Blog.GET, query = "SELECT blog FROM Blog blog WHERE blog.id =:blog_id AND blog.user.id = :user_id")
})
@Getter
@Setter
public class Blog extends BaseEntity {

    public static final String GET_ALL_BY_USER = "Blog.getByUser";
    public static final String GET_ALL = "Blog.getAll";
    public static final String DELETE = "Blog.delete";
    public static final String DELETE_BY_NAME = "Blog.deleteByName";
    public static final String GET_BY_NAME = "Blog.getByName";
    public static final String GET = "Blog.getById";

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    @Column(unique = true)
    private String url;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Blog(int id_blog, String name, String URL, User user) {
        super(id_blog);
        this.name = name;
        this.url = URL;
        this.user = user;
    }

    public Blog(int id_blog, String name, String URL) {
        super(id_blog);
        this.name = name;
        this.url = URL;
    }

    public Blog(String name, String URL) {
        this.name = name;
        this.url = URL;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog() {
    }

    @Override
    public String toString() {
        return  name ;
    }
}
