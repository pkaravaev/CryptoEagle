package com.cryptoeagle.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@NamedQueries({
        @NamedQuery(name = Ico.GET_ALL, query = "  SELECT ico FROM  Ico  ico")
//        @NamedQuery(name = Ico.GET_UPCOMING, query = "SELECT Ico  FROM  Ico ico WHERE  ico.id <:id")
})
@Cacheable
@Entity
@Getter
@Setter
public class Ico  extends BaseEntity{

    public static final String GET_ALL = "Ico.getALL";
    public static final String GET_BY_STATUS = "Ico.getByStatus";
    public static final String UPDATE = "Ico.update";
    public static final String GET_UPCOMING = "Ico.getUpcoming";

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

//    @OneToOne(fetch = FetchType.LAZY)
//    private IcoData data;
}





