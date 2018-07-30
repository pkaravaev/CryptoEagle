package com.cryptoeagle.entity;

import com.cryptoeagle.entity.crypto.Idata;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = Ico.GET_ALL, query = " SELECT ico FROM  Ico  ico"),
        @NamedQuery(name = Ico.GET_BY_ID, query = "SELECT ico  FROM  Ico ico   JOIN  Idata idata  WHERE  idata.id = ico.data.id  AND ico.id = :id"),
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
    public static final String GET_UPCOMING = "Ico.getUpcoming";
    public static final String GET_ENDED = "Ico.getEnded";
    public static final String GET_ACTIVE = "Ico.getActive";

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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Idata data;

    class IcoData{

    }
}





