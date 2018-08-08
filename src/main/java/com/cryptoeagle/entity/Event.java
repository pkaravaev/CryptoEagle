package com.cryptoeagle.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;


@Entity
@Getter
@Setter
public class Event extends BaseEntity {

    private String title;
    private String coinName;
    private String description;
    private String proof;
    private String twitter;
    private boolean isHot;
    private ZonedDateTime date_event;

}
