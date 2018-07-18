package com.cryptoeagle.entity.test;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserJpa  {

    @XmlElement
    private int id;
    @XmlElement
    private String name;
    @XmlElement
    private String password;
    @XmlElement
    private int age;
//
//    @OneToMany(mappedBy = "userJpa", cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<BlogTest> blogJpas = new ArrayList<>();

//    public List<BlogTest> getBlogJpas() {
//        return blogJpas;
//    }
//
//    public void setBlogJpas(BlogTest blogJpas) {
//        this.blogJpas.add(blogJpas);
//    }

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
