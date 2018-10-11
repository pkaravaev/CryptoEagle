package com.cryptoeagle.entity;

import com.cryptoeagle.entity.crypto.IcoData;
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
public class Ico {
    @Id
    private int id;

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

    private int page;

    private LocalDateTime preIcoStart;
    private LocalDateTime preIcoEnd;
    private LocalDateTime icoStart;
    private LocalDateTime icoEnd;


//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private IcoData data;


    public boolean isEnd() {
        if (icoEnd != null)
            return icoEnd.isBefore(LocalDateTime.now());
        else
            return false;
    }

    public boolean isUpcoming() {
        if (icoEnd != null)
        return icoStart.isAfter(LocalDateTime.now());
        else
            return false;
    }

    public boolean isActive() {
        if (icoEnd != null)
        return icoStart.isBefore(LocalDateTime.now()) && icoEnd.isAfter(LocalDateTime.now());
        else
            return false;
    }

    public String status() {

        String result = null;

        if (isEnd())
            result = "END";

        if (isUpcoming())
            result = "UPCOMING";

        if (isActive())
            result = "ACTIVE";

        return result;
    }


    public int todayMinusIcoStart() {
        return Math.abs(LocalDateTime.now().getDayOfMonth() - icoStart.getDayOfMonth());
    }

    public int todayMinusIcoEnd() {
        return Math.abs(LocalDateTime.now().getDayOfMonth() - icoEnd.getDayOfMonth());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogolink() {
        return logolink;
    }

    public void setLogolink(String logolink) {
        this.logolink = logolink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite_link() {
        return website_link;
    }

    public void setWebsite_link(String website_link) {
        this.website_link = website_link;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public LocalDateTime getPreIcoStart() {
        return preIcoStart;
    }

    public void setPreIcoStart(LocalDateTime preIcoStart) {
        this.preIcoStart = preIcoStart;
    }

    public LocalDateTime getPreIcoEnd() {
        return preIcoEnd;
    }

    public void setPreIcoEnd(LocalDateTime preIcoEnd) {
        this.preIcoEnd = preIcoEnd;
    }

    public LocalDateTime getIcoStart() {
        return icoStart;
    }

    public void setIcoStart(LocalDateTime icoStart) {
        this.icoStart = icoStart;
    }

    public LocalDateTime getIcoEnd() {
        return icoEnd;
    }

    public void setIcoEnd(LocalDateTime icoEnd) {
        this.icoEnd = icoEnd;
    }

    public IcoData getData() {
        return data;
    }

    public void setData(IcoData data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}





