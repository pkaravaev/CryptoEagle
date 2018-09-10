package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.ItemRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class ItemRepositoryJpaImpl implements ItemRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void saveAll(List<Item> list) {

        try {
            for (Item item : list){
                em.persist(item);
            }
        }
        catch (Exception e){
            System.out.println("Error : "  + e.getMessage());
        }

    }

    @Override
    public List<String> getSources() {
       return em.createNamedQuery(Item.GET_ALL_SOURCE, String.class)
                .getResultList();
    }

    @Override
    public Item save(Item item, int blog_id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteAll() {
        em.createQuery("DELETE FROM Item ").executeUpdate();
    }

    @Override
    public void delete(int id, int blog_id) {

    }

    @Override
    @Transactional
    public List<Item> getBySource(String source) {
        return em.createNamedQuery(Item.GET_BY_SOURCE, Item.class)
                .setParameter("source", source)
                .getResultList();
    }

    @Override
    public Item get(int id, int blog_id) {
        return null;
    }

    @Override
    public List<Item> getall(int blog_id) {
        return null;
    }

    @Override
    @Transactional
    public List<Item> getall() {
        return em.createNamedQuery(Item.GET_ALL, Item.class)
                .getResultList();
    }
}
