package com.cryptoeagle.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = Item.GET_ALL, query = "SELECT item FROM Item  item"),
        @NamedQuery(name = Item.GET_BY_SOURCE, query = "SELECT item FROM Item item WHERE item.source =:source")
})
@Getter
@Setter
public class Item extends BaseEntity implements EntityWithPic {

    public final static String GET_ALL = "Item.GetAll";
    public final static String GET_BY_SOURCE = "Item.GetBySource";

    private String title;
    private String description;
    private Date publishDate;
    private String link;
    private String source;

    @ManyToOne(cascade = CascadeType.ALL)
    private Blog blog;

    public Item(int id_item, String title, String description, Date publishDate, String link) {
        super(id_item);
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.link = link;
    }

    public Item(String title, String description, Date publishDate, String link) {
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.link = link;
    }

    public Item() {
    }



}
