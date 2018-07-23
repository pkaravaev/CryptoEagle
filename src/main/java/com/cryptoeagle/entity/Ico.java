package com.cryptoeagle.entity;


import com.cryptoeagle.entity.ENU.IcoStatus;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Ico.GET_ALL,query = "SELECT ico FROM  Ico  ico"),
        @NamedQuery(name = Ico.GET_BY_STATUS,query = "SELECT ico FROM  Ico  ico WHERE  ico.status=: status")
})
@Entity
public class Ico {

    public static final String GET_ALL ="Ico.getALL";
    public static final String GET_BY_STATUS ="Ico.getByStatus";


    @Id
    @GeneratedValue
    private int id;
    private String name;
    private IcoStatus status;
    private String image;
    private String description;
    private String website_link;
    private String icowatchlist_url;
    private String start_time;
    private String end_time;
    private String timezone;
    private String coin_symbol;
    private String price_usd;
    private String all_time_roi;

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

    public Ico(){};

    // Getter Methods

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

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getCoin_symbol() {
        return coin_symbol;
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public String getAll_time_roi() {
        return all_time_roi;
    }

    // Setter Methods

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

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setCoin_symbol(String coin_symbol) {
        this.coin_symbol = coin_symbol;
    }

    public void setPrice_usd(String price_usd) {
        this.price_usd = price_usd;
    }

    public void setAll_time_roi(String all_time_roi) {
        this.all_time_roi = all_time_roi;
    }
}