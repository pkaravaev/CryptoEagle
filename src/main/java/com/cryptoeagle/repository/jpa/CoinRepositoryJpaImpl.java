package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class CoinRepositoryJpaImpl implements CoinRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Coin getById(int id) {
        return entityManager.createNamedQuery(Coin.GET_BY_ID, Coin.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Coin getBySymbol(String symbol) {
        return entityManager.createNamedQuery(Coin.GET_BY_SYMBOL, Coin.class)
                .setParameter("symbol", symbol)
                .getSingleResult();
    }

    @Override
    @Transactional
    public void saveCoins(List<Coin> list) {
        for (Coin c : list) {
            entityManager.persist(c);
        }
    }

    @Override
    public List<Coin> getAllCoins() {
        return entityManager.createNamedQuery(Coin.GET_ALL, Coin.class)
                .getResultList();
    }

    @Override
    public List<Coin> getTopGainCoins() {
        return entityManager.createNamedQuery(Coin.GET_TOP, Coin.class)
                .getResultList().stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<Coin> getTopLoserCoins() {
        return entityManager.createNamedQuery(Coin.GET_LOSER, Coin.class)
                .getResultList().stream()
                .limit(10)
                .collect(Collectors.toList());
    }
}

