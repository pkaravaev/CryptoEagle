package com.cryptoeagle.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@NamedQueries({
        @NamedQuery(name = Ico.GET_ALL, query = "  SELECT ico FROM  Ico  ico")
//        @NamedQuery(name = Ico.GET_UPCOMING, query = "SELECT Ico  FROM  Ico ico WHERE  ico.id <:id")
})

@Cacheable
@Inheritance
@Entity
public class Ico {

    public static final String GET_ALL = "Ico.getALL";
    public static final String GET_BY_STATUS = "Ico.getByStatus";
    public static final String UPDATE = "Ico.update";
    public static final String GET_UPCOMING = "Ico.getUpcoming";


    @Id
    @GeneratedValue
    public int id;
    private String name;
    private String logolink;
    private String description;
    private String website_link;
    private double rating;

    private int page;


    private LocalDateTime preIcoStart;
    private LocalDateTime preIcoEnd;
    private LocalDateTime icoStart;
    private LocalDateTime icoEnd;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getPreIcoStart() {
        return preIcoStart;
    }

    public void setPreIcoStart(LocalDateTime preIcoStart) {
        this.preIcoStart = preIcoStart;
    }

    public LocalDateTime getPreIcoEnd() {
        return preIcoEnd;
    }

    public void setPreIcoEnd(LocalDateTime preIcoEnd) {
        this.preIcoEnd = preIcoEnd;
    }

    public LocalDateTime getIcoStart() {
        return icoStart;
    }

    public void setIcoStart(LocalDateTime icoStart) {
        this.icoStart = icoStart;
    }

    public LocalDateTime getIcoEnd() {
        return icoEnd;
    }

    public void setIcoEnd(LocalDateTime icoEnd) {
        this.icoEnd = icoEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ico() {
    }

    public String getName() {
        return name;
    }

    public String getLogolink() {
        return logolink;
    }

    public String getDescription() {
        return description;
    }

    public String getWebsite_link() {
        return website_link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogolink(String image) {
        this.logolink = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWebsite_link(String website_link) {
        this.website_link = website_link;
    }

}