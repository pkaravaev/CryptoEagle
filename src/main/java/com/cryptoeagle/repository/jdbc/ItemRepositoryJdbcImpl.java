package com.cryptoeagle.repository.jdbc;


import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Repository
public class ItemRepositoryJdbcImpl implements ItemRepository {
    @Override
    public List<Item> getBySource(String source) {
        return null;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<Item> rowMapper = BeanPropertyRowMapper.newInstance(Item.class);

    @Override
    public void deleteAll() {

    }

    @Override
    public void saveAll(List<Item> list) {

    }

    @Override
    public Item save(Item item, int blog) {
        return null;
    }

    @Override
    public void delete(int id, int blog) {

    }

    @Override
    public Item get(int id, int blog) {
        return null;
    }

    @Override
    public List<Item> getall(int blog_id) {
        return jdbcTemplate.query("SELECT * FROM items WHERE id_blog=?", rowMapper, blog_id);
    }

    @Override
    public List<Item> getall() {
        return jdbcTemplate.query("SELECT * FROM items", rowMapper);
    }
}
