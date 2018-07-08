package com.cryptoeagle.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class User  {

    private int id;

    private String name;
    private String email;
    private String password;
    private boolean enable;
    private boolean admin;
    private List<Blog> blogs = new ArrayList<>();
    private List<Role> roles = new ArrayList<>();

    public User(int id,String name, String email, String password, boolean enable, boolean admin) {
//        super(id);
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.enable = enable;
        this.admin = admin;
    }

    public User(String name, String email, String password, boolean enable, boolean admin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.enable = enable;
        this.admin = admin;
    }


    public User() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNew(){
        return id == 0;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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
