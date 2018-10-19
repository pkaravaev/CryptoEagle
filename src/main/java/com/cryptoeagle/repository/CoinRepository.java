package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Coin;

import java.util.List;

public interface CoinRepository {

    Coin getBySymbol(String symbol);

    List<Coin> getBySymbols(List<String> symbols);




    void save(Coin coin);

    void deleteAll();

    void delete(Coin coin);



    List<Coin> getAllCoins();

    List<Coin> getTopGainCoins();

    List<Coin> getTopLoserCoins();

}
