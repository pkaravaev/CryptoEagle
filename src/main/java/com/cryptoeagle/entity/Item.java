package com.cryptoeagle.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = Item.GET_ALL, query = "SELECT item FROM Item  item")
})
public class Item extends BaseEntity {

    public final static String GET_ALL = "Item.GetAll";

    private String title;
    private String description;
    private Date publishDate;
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    private Blog blog;

    public Item(int id_item, String title, String description, Date publishDate, String link) {
        super(id_item);
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.link = link;
    }

    public Item( String title, String description, Date publishDate, String link) {
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.link = link;
    }

    public Item(){}

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}
