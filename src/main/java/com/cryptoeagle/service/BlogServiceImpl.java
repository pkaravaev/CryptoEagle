package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.BlogRepository;
import com.cryptoeagle.service.abst.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service
public class BlogServiceImpl implements BlogService {

    private static final Logger log = Logger.getLogger(BlogServiceImpl.class.getName());

    @Autowired
    BlogRepository repository;

    @Override
    public void save(Blog blog, int user_id) {
        log.info("save blog");
        repository.save(blog, user_id);
    }

    @Override
    public void update(Blog blog, int user_id) {
        log.info("update blog");
        repository.save(blog, user_id);
    }

    @Override
    public List<Blog> findall(int user_id) {
        log.info("get all blogs by user");
      return repository.getallByUser(user_id);
    }

    @Override
    public List<Item> itemsFromBlogs(int user_id) {
        return null;
    }

    @Override
    public void delete(int blog_id, int user_id) {
        log.info("delete blog");
        repository.delete(blog_id,user_id);
    }

    @Override
    public List<Blog> getAll() {
        log.info("get all blogs");
        return repository.getAll();
    }
}
