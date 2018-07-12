package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.ItemRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class ItemRepositoryJpaImpl implements ItemRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Item save(Item item, int blog_id) {
        return null;
    }

    @Override
    public void delete(int id, int blog_id) {

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
    public List<Item> getall() {
        return null;
    }
}
