package com.cryptoeagle.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = Blog.GET_ALL, query = "SELECT blog FROM Blog blog"),
        @NamedQuery(name = Blog.GET_BY_NAME, query = "SELECT blog FROM Blog blog where blog.name =: name"),
        @NamedQuery(name = Blog.GET_BY_ID, query = "SELECT blog FROM Blog blog where blog.id =:id"),
})
@Data
public class Blog extends BaseEntity {

    public static final String GET_ALL_BY_USER = "Blog.getByUser";
    public static final String GET_ALL = "Blog.getAll";
    public static final String GET_BY_NAME = "Blog.getByName";
    public static final String GET_BY_ID = "Blog.getById";

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    @Column(unique = true)
    private String url;

    @ManyToOne
    private User user;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Item> items = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<>();

    public Blog(String name, String URL) {
        this.name = name;
        this.url = URL;
    }

    public Blog() {


    }
}
