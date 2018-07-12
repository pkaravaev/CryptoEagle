package com.cryptoeagle.entity.test;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class UserJpa  {

//    @Id
//    @GeneratedValue
    private int id;

    private String name;
    private String password;
    private int age;
//
//    @OneToMany(mappedBy = "userJpa", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<BlogJpa> blogJpas = new ArrayList<>();

    public List<BlogJpa> getBlogJpas() {
        return blogJpas;
    }

    public void setBlogJpas(BlogJpa blogJpas) {
        this.blogJpas.add(blogJpas);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_userjpa) {
        this.id = id_userjpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
