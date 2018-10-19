package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.repository.CoinRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class CoinRepositoryJpaImpl implements CoinRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Coin getBySymbol(String symbol) {

        return em.createNamedQuery(Coin.GET_BY_SYMBOL, Coin.class)
                .setParameter("symbol", symbol)
                .getSingleResult();
    }

    @Override
    public List<Coin> getBySymbols(List<String> symbols) {
        return em.createNamedQuery(Coin.GET_BY_SYMBOLS, Coin.class)
                .setParameter("symbols", symbols)
                .getResultList();
    }

    @Override
    public void save(Coin coin) {

        em.persist(coin);
    }

    @Override
    public void deleteAll() {
        em.createQuery("DELETE FROM Coin ").executeUpdate();
    }

    @Override
    public List<Coin> getAllCoins() {
        return em.createNamedQuery(Coin.GET_ALL, Coin.class)
                .getResultList();
    }

    @Override
    public List<Coin> getTopGainCoins() {
        return em.createNamedQuery(Coin.GET_TOP, Coin.class)
                .getResultList().stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<Coin> getTopLoserCoins() {
        return em.createNamedQuery(Coin.GET_LOSER, Coin.class)
                .getResultList().stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Coin coin) {
        em.remove(coin);
    }

}


