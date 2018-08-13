package com.cryptoeagle.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = Item.GET_ALL, query = "SELECT item FROM Item  item order by item.publishDate desc "),
        @NamedQuery(name = Item.GET_BY_SOURCE, query = "SELECT item FROM Item item WHERE item.source =:source order by item.publishDate desc "),
        @NamedQuery(name = Item.GET_ALL_SOURCE, query = "SELECT DISTINCT item.source FROM Item item")
})
@Getter
@Setter
public class Item extends BaseEntity implements EntityWithPic {

    public final static String GET_ALL = "Item.GetAll";
    public final static String GET_BY_SOURCE = "Item.GetBySource";
    public final static String GET_ALL_SOURCE = "Item.GetAllSource";

    private String title;
    @Lob
    private String description;
    private LocalDateTime publishDate;
    private String link;
    private String source;

    public int diffDays() {
        return Math.abs(LocalDateTime.now().getDayOfMonth() - publishDate.getDayOfMonth());
    }

    public int diffMinutes() {

//        Period period = Period.between(LocalDateTime.now().toLocalDate(), publishDate.toLocalDate());
        Duration between = Duration.between(LocalDateTime.now().toLocalTime(), publishDate.toLocalTime());
//        return LocalDateTime.now().getMinute() - publishDate.getMinute();

        return Math.abs(((int)between.toMinutes()));
    }

    public int diffHours() {

        Duration between = Duration.between(LocalDateTime.now().toLocalTime(), publishDate.toLocalTime());
        Period period = Period.between(LocalDateTime.now().toLocalDate(), publishDate.toLocalDate());
        int i = (int)between.toHours();

        return  Math.abs(i);
//        return LocalDateTime.now().getHour() - publishDate.getHour();
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private Blog blog;

    public Item(int id_item, String title, String description, LocalDateTime publishDate, String link) {
        super(id_item);
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.link = link;
    }

    public Item(String title, String description, LocalDateTime publishDate, String link) {
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.link = link;
    }

    public Item() {
    }



}
