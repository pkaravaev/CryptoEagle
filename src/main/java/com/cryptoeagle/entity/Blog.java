package com.cryptoeagle.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = Blog.GET_ALL_BY_USER, query = "SELECT blog FROM Blog blog WHERE blog.appUser.id =:user_id"),
        @NamedQuery(name = Blog.DELETE, query = "DELETE FROM Blog blog WHERE blog.id =:blog_id AND blog.appUser.id =: user_id"),
        @NamedQuery(name = Blog.GET, query = "SELECT blog FROM Blog blog WHERE blog.id =:blog_id AND blog.appUser.id = :user_id")
})
@Getter
@Setter
@ToString
public class Blog extends BaseEntity {

    public static final String GET_ALL_BY_USER = "Blog.getByUser";
    public static final String DELETE = "Blog.delete";
    public static final String GET = "Blog.getById";

    private String name;
    private String url;
    @OneToMany(mappedBy = "blog", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Item.class)
    private List<Item> items = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private AppUser appUser;


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
