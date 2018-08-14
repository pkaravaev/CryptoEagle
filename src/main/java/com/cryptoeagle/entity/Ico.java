package com.cryptoeagle.entity;

import com.cryptoeagle.entity.crypto.Idata;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = Ico.GET_ALL, query = " SELECT ico FROM  Ico  ico"),
        @NamedQuery(name = Ico.GET_BY_ID, query = "SELECT ico  FROM  Ico ico   WHERE  ico.id = :id"),
        @NamedQuery(name = Ico.GET_BY_NAME, query = "SELECT ico  FROM  Ico ico   WHERE  ico.name = :name"),
        @NamedQuery(name = Ico.GET_UPCOMING, query = "SELECT ico  FROM  Ico ico WHERE  ico.icoStart > :date"),
        @NamedQuery(name = Ico.GET_ENDED, query = "SELECT ico  FROM  Ico ico WHERE  ico.icoEnd < :date"),
        @NamedQuery(name = Ico.GET_ACTIVE, query = "SELECT ico  FROM  Ico ico WHERE  ico.icoEnd > :date"),
})
@Cacheable
@Entity
@Getter
@Setter
public class Ico {

    @Id
    private int id;

    public static final String GET_ALL = "Ico.getALL";
    public static final String GET_BY_ID = "Ico.getById";
    public static final String GET_BY_NAME = "Ico.getByName";
    public static final String GET_UPCOMING = "Ico.getUpcoming";
    public static final String GET_ENDED = "Ico.getEnded";
    public static final String GET_ACTIVE = "Ico.getActive";

    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String logolink;
    @NotNull
    private String description;
    @NotNull
    private String website_link;
    @NotNull
    private double rating;

    private int page;

    private LocalDateTime preIcoStart;
    private LocalDateTime preIcoEnd;
    private LocalDateTime icoStart;
    private LocalDateTime icoEnd;

    public int todayMinusIcoStart() {
        return LocalDateTime.now().getDayOfMonth() - icoStart.getDayOfMonth();
    }

    public int todayMinusIcoEnd() {
        return Math.abs(LocalDateTime.now().getDayOfMonth() - icoEnd.getDayOfMonth());
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Idata data;

    class IcoData {
    }

}





