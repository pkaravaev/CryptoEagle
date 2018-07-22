package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.repository.CoinRepository;

import java.util.List;

public class CoinRepositoryJpaImpl implements CoinRepository {


    @Override
    public Coin getById(int id) {
        return null;
    }

    @Override
    public Coin getBySymbol(String symbol) {
        return null;
    }

    @Override
    public void saveCoins(List<Coin> list) {

    }

    @Override
    public List<Coin> getAllCoins() {
        return null;
    }

    @Override
    public List<Coin> getTopGainCoins() {
        return null;
    }

    @Override
    public List<Coin> getTopLoserCoins() {
        return null;
    }
}


