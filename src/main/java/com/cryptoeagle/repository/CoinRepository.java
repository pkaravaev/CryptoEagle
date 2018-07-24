package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Coin;

import java.util.List;

public interface CoinRepository {

    Coin getById(int id);

    Coin getBySymbol(String symbol);

    void saveCoins(List<Coin> list);

    void deleteAll();

    List<Coin> getAllCoins();

    List<Coin> getTopGainCoins();

    List<Coin> getTopLoserCoins();

}
