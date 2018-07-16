package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.BlogRepository;
import com.cryptoeagle.service.abst.BlogService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

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
}
