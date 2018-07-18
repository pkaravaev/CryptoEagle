package com.cryptoeagle.entity.test;


import javax.persistence.*;
import javax.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BlogTest {

    @XmlElement
    private int id;
    @XmlElement
    private String name;
    @XmlElement
    private String url;

    public BlogTest(String blogname, String url) {
        this.name = blogname;
        this.url = url;
    }

    public BlogTest() {
    }

    @XmlElement
    public UserJpa userJpa;

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }


    public void setName(String blogname) {
        this.name = blogname;
    }

    public int getId() {
        return id;
    }


    public void setId(int id_blogjpa) {
        this.id = id_blogjpa;
    }

    public UserJpa getUserJpa() {
        return userJpa;
    }

    public void setUserJpa(UserJpa userJpa) {
        this.userJpa = userJpa;
    }
}
