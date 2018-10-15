package com.cryptoeagle.entity;

import com.cryptoeagle.entity.crypto.IcoData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = Ico.GET_ALL, query = " SELECT ico FROM  Ico  ico "),
        @NamedQuery(name = Ico.GET_BY_ID, query = "SELECT ico  FROM  Ico ico   WHERE  ico.id = :id"),
        @NamedQuery(name = Ico.GET_BY_NAME, query = "SELECT ico  FROM  Ico ico   WHERE  ico.name = :name"),
        @NamedQuery(name = Ico.GET_BY_NAMES, query = "SELECT ico  FROM  Ico ico   WHERE  ico.name = :names"),
        @NamedQuery(name = Ico.GET_UPCOMING, query = "SELECT ico  FROM  Ico ico WHERE  ico.icoStart > :date order by ico.icoStart desc "),
        @NamedQuery(name = Ico.GET_ENDED, query = "SELECT ico  FROM  Ico ico WHERE  ico.icoEnd < :date order by ico.icoEnd desc "),
        @NamedQuery(name = Ico.GET_ACTIVE, query = "SELECT ico  FROM  Ico ico WHERE  ico.icoEnd > :date AND ico.icoStart < :date order by ico.icoStart asc"),
})
@Entity
@Data
public class Ico extends BaseEntity {

    public static final String GET_ALL = "Ico.getALL";
    public static final String GET_BY_ID = "Ico.getById";
    public static final String GET_BY_NAME = "Ico.getByName";
    public static final String GET_BY_NAMES = "Ico.getByNames";
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

    private LocalDateTime preIcoStart;
    private LocalDateTime preIcoEnd;
    private LocalDateTime icoStart;
    private LocalDateTime icoEnd;

    private IcoData data;

    public boolean isEnd() {
        return icoEnd != null && icoEnd.isBefore(LocalDateTime.now());
    }

    public boolean isUpcoming() {
        return icoEnd != null && icoStart.isAfter(LocalDateTime.now());
    }

    public boolean isActive() {
        return icoEnd != null && icoStart.isBefore(LocalDateTime.now()) && icoEnd.isAfter(LocalDateTime.now());
    }

    public String status() {
        if (isEnd())
            return "END";
        if (isUpcoming())
            return "UPCOMING";
        if (isActive())
            return "ACTIVE";
        return "no status";
    }


    public int todayMinusIcoStart() {
        return Math.abs(LocalDateTime.now().getDayOfMonth() - icoStart.getDayOfMonth());
    }

    public int todayMinusIcoEnd() {
        return Math.abs(LocalDateTime.now().getDayOfMonth() - icoEnd.getDayOfMonth());
    }

}





