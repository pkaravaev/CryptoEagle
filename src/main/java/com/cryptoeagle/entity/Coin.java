package com.cryptoeagle.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public  class Coin {
    public final Data data;
    public final Metadata metadata;

    @JsonCreator
    public Coin(@JsonProperty("data") Data data, @JsonProperty("metadata") Metadata metadata){
        this.data = data;
        this.metadata = metadata;
    }

    public static final class Data {
        public final long id;
        public final String name;
        public final String symbol;
        public final String website_slug;
        public final long rank;
        public final long circulating_supply;
        public final long total_supply;
        public final long max_supply;
        public final Quotes quotes;
        public final long last_updated;

        @JsonCreator
        public Data(@JsonProperty("id") long id, @JsonProperty("name") String name, @JsonProperty("symbol") String symbol, @JsonProperty("website_slug") String website_slug, @JsonProperty("rank") long rank, @JsonProperty("circulating_supply") long circulating_supply, @JsonProperty("total_supply") long total_supply, @JsonProperty("max_supply") long max_supply, @JsonProperty("quotes") Quotes quotes, @JsonProperty("last_updated") long last_updated){
            this.id = id;
            this.name = name;
            this.symbol = symbol;
            this.website_slug = website_slug;
            this.rank = rank;
            this.circulating_supply = circulating_supply;
            this.total_supply = total_supply;
            this.max_supply = max_supply;
            this.quotes = quotes;
            this.last_updated = last_updated;
        }

        public static final class Quotes {
            public final USD USD;

            @JsonCreator
            public Quotes(@JsonProperty("uSD") USD USD){
                this.USD = USD;
            }

            public static final class USD {
                public final double price;
                public final long volume_24h;
                public final long market_cap;
                public final double percent_change_1h;
                public final double percent_change_24h;
                public final double percent_change_7d;

                @JsonCreator
                public USD(@JsonProperty("price") double price, @JsonProperty("volume_24h") long volume_24h, @JsonProperty("market_cap") long market_cap, @JsonProperty("percent_change_1h") double percent_change_1h, @JsonProperty("percent_change_24h") double percent_change_24h, @JsonProperty("percent_change_7d") double percent_change_7d){
                    this.price = price;
                    this.volume_24h = volume_24h;
                    this.market_cap = market_cap;
                    this.percent_change_1h = percent_change_1h;
                    this.percent_change_24h = percent_change_24h;
                    this.percent_change_7d = percent_change_7d;
                }
            }
        }
    }

    public static final class Metadata {
        public final long timestamp;
        public final Error error;

        @JsonCreator
        public Metadata(@JsonProperty("timestamp") long timestamp, @JsonProperty("error") Error error){
            this.timestamp = timestamp;
            this.error = error;
        }

        public static final class Error {

            @JsonCreator
            public Error(){
            }
        }
    }

    public double getPrice(){
        return this.data.quotes.USD.price;
    }
    public String  getName(){
        return this.data.name;
    }
    public String  getSymbol(){
        return this.data.symbol;
    }
}