package com.cryptoeagle.entity;


import com.cryptoeagle.entity.enumeration.IcoStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = Ico.GET_ALL, query = "SELECT ico FROM  Ico  ico"),
        @NamedQuery(name = Ico.GET_BY_STATUS, query = "SELECT ico FROM  Ico  ico WHERE  ico.status=: status"),
        @NamedQuery(name = Ico.UPDATE, query = "UPDATE Ico  ico Set ico.price_usd=:price, ico.all_time_roi=:roi"),
})
@Entity
@Cacheable
public class Ico {

    public static final String GET_ALL = "Ico.getALL";
    public static final String GET_BY_STATUS = "Ico.getByStatus";
    public static final String UPDATE = "Ico.update";

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private IcoStatus status;
    private String image;
    private String description;
    private String website_link;
    private String icowatchlist_url;

    private LocalDateTime preIcoStart;
    private LocalDateTime preIcoEnd;
    private LocalDateTime icoStart;
    private LocalDateTime icoEnd;

    private String timezone;
    private String coin_symbol;
    private double price_usd;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private double rating;
    private double all_time_roi;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IcoStatus getStatus() {
        return status;
    }

    public void setStatus(IcoStatus status) {
        this.status = status;
    }

    public Ico() {
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getWebsite_link() {
        return website_link;
    }

    public String getIcowatchlist_url() {
        return icowatchlist_url;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getCoin_symbol() {
        return coin_symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWebsite_link(String website_link) {
        this.website_link = website_link;
    }

    public void setIcowatchlist_url(String icowatchlist_url) {
        this.icowatchlist_url = icowatchlist_url;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setCoin_symbol(String coin_symbol) {
        this.coin_symbol = coin_symbol;
    }

    public double getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(double price_usd) {
        this.price_usd = price_usd;
    }

    public double getAll_time_roi() {
        return all_time_roi;
    }

    public void setAll_time_roi(double all_time_roi) {
        this.all_time_roi = all_time_roi;
    }
}