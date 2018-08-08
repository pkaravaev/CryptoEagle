package com.cryptoeagle.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;


@NamedQueries({
        @NamedQuery( name = Event.GET_ALL, query = "SELECT event FROM Event event ORDER BY event.date_event desc "),
        @NamedQuery( name = Event.GET_BY_COIN_NAME, query = "SELECT event FROM Event event WHERE event.coinName=:coinname ORDER BY event.date_event desc ")
})

@Entity
@Getter
@Setter
public class Event extends BaseEntity {

    public static final String GET_ALL = "Event.getAll";
    public static final String GET_BY_COIN_NAME = "Event.getByCoinName";

    private String title;
    private String coinName;
    private String name;
    private String description;
    private String proof;
    private String source;
    private String twitter;
    private boolean isHot;
    private ZonedDateTime date_event;

    public int diffNowBeetweenDataEventDay()
    {
        return date_event.getDayOfMonth() - ZonedDateTime.now().getDayOfMonth() ;
    }

    public int diffNowBeetweenDataEventMinute()
    {
        return date_event.getMinute() - ZonedDateTime.now().getMinute() ;
    }

}
