package com.cryptoeagle.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = Blog.GET_ALL_BY_USER, query = "SELECT blog FROM Blog blog WHERE blog.appUser.id =:user_id"),
        @NamedQuery(name = Blog.GET_ALL, query = "SELECT blog FROM Blog blog"),
        @NamedQuery(name = Blog.DELETE, query = "DELETE FROM Blog blog WHERE blog.id =:blog_id AND blog.appUser.id =: user_id"),
        @NamedQuery(name = Blog.GET, query = "SELECT blog FROM Blog blog WHERE blog.id =:blog_id AND blog.appUser.id = :user_id")
})
@Getter
@Setter
public class Blog extends BaseEntity {

    public static final String GET_ALL_BY_USER = "Blog.getByUser";
    public static final String GET_ALL = "Blog.getAll";
    public static final String DELETE = "Blog.delete";
    public static final String GET = "Blog.getById";

    @NotNull
    private String name;

    @Column(unique = true)
    private String url;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private AppUser appUser;


    public Blog(int id_blog, String name, String URL, AppUser appUser) {
        super(id_blog);
        this.name = name;
        this.url = URL;
        this.appUser = appUser;
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

    public Blog() {
    }
}
