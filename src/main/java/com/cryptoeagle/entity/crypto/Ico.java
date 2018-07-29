package com.cryptoeagle.entity.crypto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = Ico.GET_ALL, query = " SELECT ico FROM  Ico  ico"),
        @NamedQuery(name = Ico.GET_BY_ID, query = "SELECT ico  FROM  Ico ico WHERE  ico.id =:id")
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
    private IcoData data;
}





