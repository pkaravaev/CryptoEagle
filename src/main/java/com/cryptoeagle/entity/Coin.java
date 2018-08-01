package com.cryptoeagle.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Cacheable
@NamedQueries({
        @NamedQuery(name = Coin.GET_BY_ID, query = "SELECT c FROM Coin c WHERE c.id=:id"),
        @NamedQuery(name = Coin.GET_ALL, query = "SELECT c FROM Coin c"),
        @NamedQuery(name = Coin.GET_BY_SYMBOL, query = "SELECT c FROM Coin c WHERE c.symbol=:symbol"),
        @NamedQuery(name = Coin.GET_TOP, query = "SELECT c FROM Coin c order by c.percent_change_7d desc "),
        @NamedQuery(name = Coin.GET_LOSER, query = "SELECT c FROM Coin c order by c.percent_change_7d asc "),
        @NamedQuery(name = Coin.UPDATE, query = "UPDATE Coin c Set c.rank=:rank, c.circulating_supply=:circulating_supply," +
                "c.price=:price, c.volume_24h=:volume_24h, c.market_cap=:market_cap, c.percent_change_1h=:percent_change_1h," +
                "c.percent_change_24h=:percent_change_24h,c.percent_change_7d=:percent_change_7d")
})
@Getter
@Setter
public class Coin extends BaseEntity {

    public static final String GET_BY_ID = "Coin.getById";
    public static final String GET_ALL = "Coin.getAll";
    public static final String GET_BY_SYMBOL = "Coin.getBySymbol";
    public static final String GET_TOP = "Coin.getTop";
    public static final String GET_LOSER = "Coin.getLoser";
    public static final String UPDATE = "Coin.update";

    private String name;
    private String image;
    private String symbol;
    private int rank;
    private BigDecimal circulating_supply;
    private double price;
    private BigDecimal volume_24h;
    private BigDecimal market_cap;
    private double percent_change_1h;
    private double percent_change_7d;
    private double percent_change_24h;


}