package com.cryptoeagle.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@Cacheable
@NamedQueries({
        @NamedQuery(name = Coin.GET_BY_ID, query = "SELECT c FROM Coin c WHERE c.id=:id"),
        @NamedQuery(name = Coin.GET_ALL, query = "SELECT c FROM Coin c"),
        @NamedQuery(name = Coin.GET_BY_SYMBOL, query = "SELECT c FROM Coin c WHERE c.symbol=:symbol"),
        @NamedQuery(name = Coin.GET_BY_SYMBOLS, query = "SELECT c FROM Coin c WHERE c.symbol in :symbols"),
        @NamedQuery(name = Coin.GET_TOP, query = "SELECT c FROM Coin c order by c.percent_change_7d desc "),
        @NamedQuery(name = Coin.GET_LOSER, query = "SELECT c FROM Coin c order by c.percent_change_7d asc "),
        @NamedQuery(name = Coin.UPDATE, query = "UPDATE Coin c Set c.rank=:rank, c.circulating_supply=:circulating_supply," +
                "c.price=:price, c.volume_24h=:volume_24h, c.market_cap=:market_cap, c.percent_change_1h=:percent_change_1h," +
                "c.percent_change_24h=:percent_change_24h,c.percent_change_7d=:percent_change_7d")
})
public class Coin extends BaseEntity {

    public static final String GET_BY_ID = "Coin.getById";
    public static final String GET_ALL = "Coin.getAll";
    public static final String GET_BY_SYMBOL = "Coin.getBySymbol";
    public static final String GET_BY_SYMBOLS = "Coin.getBySymbols";
    public static final String GET_TOP = "Coin.getTop";
    public static final String GET_LOSER = "Coin.getLoser";
    public static final String UPDATE = "Coin.update";

    @Column(unique = true)
    private String name;
    @Column
    private String image;
    @Column(unique = true)
    private String symbol;
    @NotNull
    private int rank;
    @NotNull
    private BigDecimal circulating_supply;
    @NotNull
    private double price;
    @NotNull
    private BigDecimal volume_24h;
    @NotNull
    private BigDecimal market_cap;
    @NotNull
    private double percent_change_1h;
    @NotNull
    private double percent_change_7d;
    @NotNull
    private double percent_change_24h;
    @NotNull
    private boolean dataAvailable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public BigDecimal getCirculating_supply() {
        return circulating_supply;
    }

    public void setCirculating_supply(BigDecimal circulating_supply) {
        this.circulating_supply = circulating_supply;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BigDecimal getVolume_24h() {
        return volume_24h;
    }

    public void setVolume_24h(BigDecimal volume_24h) {
        this.volume_24h = volume_24h;
    }

    public BigDecimal getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(BigDecimal market_cap) {
        this.market_cap = market_cap;
    }

    public double getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(double percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public double getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public double getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public boolean isDataAvailable() {
        return dataAvailable;
    }

    public void setDataAvailable(boolean dataAvailable) {
        this.dataAvailable = dataAvailable;
    }
}