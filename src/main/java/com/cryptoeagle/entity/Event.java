package com.cryptoeagle.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;


@NamedQueries({
        @NamedQuery( name = Event.GET_ALL, query = "SELECT event FROM Event event ORDER BY event.date_event desc "),
        @NamedQuery( name = Event.GET_BY_COIN_NAME, query = "SELECT event FROM Event event WHERE event.coinName=:coinname ORDER BY event.date_event desc ")
})

@Entity
public class Event extends BaseEntity {

    public static final String GET_ALL = "Event.getAll";
    public static final String GET_BY_COIN_NAME = "Event.getByCoinName";

    @Column(unique = true)
    private String title;
    @NotNull
    private String coinName;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String proof;
    @NotNull
    private String source;
    @NotNull
    private String twitter;
    @NotNull
    private boolean isHot;
    @NotNull
    private ZonedDateTime date_event;

    public int diffNowBeetweenDataEventDay()
    {
        return Math.abs(date_event.getDayOfMonth() - ZonedDateTime.now().getDayOfMonth());
    }

    public int diffNowBeetweenDataEventMinute()
    {
        return Math.abs(date_event.getMinute() - ZonedDateTime.now().getMinute());
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public ZonedDateTime getDate_event() {
        return date_event;
    }

    public void setDate_event(ZonedDateTime date_event) {
        this.date_event = date_event;
    }
}
