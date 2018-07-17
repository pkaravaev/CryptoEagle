package com.cryptoeagle.entity;

public class Ico {
    private String name;
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