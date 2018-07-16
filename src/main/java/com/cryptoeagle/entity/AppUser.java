package com.cryptoeagle.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity

@NamedQueries( {
        @NamedQuery( name = AppUser.DELETE, query = "DELETE FROM AppUser u WHERE u.id=:id"),
        @NamedQuery(name = AppUser.GET_ALL, query = "SELECT user FROM AppUser user"),
        @NamedQuery(name = AppUser.GET_BY_EMAIL, query = "SELECT user FROM AppUser  user WHERE user.email=:email"),
        @NamedQuery(name = AppUser.GET_BY_ID, query = "SELECT user FROM AppUser user WHERE user.id=:id")

})

public class AppUser extends BaseEntity  {

    public static final String DELETE = "AppUser.delete";
    public static final String GET_BY_ID = "AppUser.get";
    public static final String GET_ALL = "AppUser.getall";
    public static final String GET_BY_EMAIL = "AppUser.getByEmail";


    private String name;
    private String email;
    private String password;
    private boolean enable;
    private boolean admin;

    @OneToMany(mappedBy = "appUser",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Blog> blogs = new ArrayList<>();

//    @OneToMany(mappedBy = "user")
//    private List<Role> roles = new ArrayList<>();

    public AppUser(int id, String name, String email, String password, boolean enable, boolean admin) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.enable = enable;
        this.admin = admin;
    }

    public AppUser(String name, String email, String password, boolean enable, boolean admin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.enable = enable;
        this.admin = admin;
    }


    public AppUser() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == 0;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }


    public void setBlogs(Blog blog) {
        blogs.add(blog);
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

//    public List<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }


    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}
