package com.cryptoeagle.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries( {
     @NamedQuery(name = WhiteList.GET_ALL, query ="select whitelist from WhiteList whitelist")
})

public class WhiteList  extends BaseEntity implements Comparable<WhiteList> {

    public  static final String GET_ALL = "Get.All";

    private String status;
    private String name;
    private String logo;
    private String category;



    @Override
    public int compareTo(WhiteList o) {
        return this.name.length() - o.name.length();
    }

    public static String getGetAll() {
        return GET_ALL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
