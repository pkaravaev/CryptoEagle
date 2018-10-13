package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.exception.RssNewsNotFoundException;
import com.cryptoeagle.repository.BlogRepository;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;


@Service
public class BlogServiceImpl implements BlogService {

    private static final Logger log = Logger.getLogger(BlogServiceImpl.class.getName());


    BlogRepository blogRepository;

    RssService rssService;

    @Autowired
    public BlogServiceImpl(RssService rssService, BlogRepository blogRepository) {
        this.rssService = rssService;
        this.blogRepository = blogRepository;
    }

    @Override
    @Transactional
    public void deleteAll() {
        List<Blog> all = getAll();
        for (Blog blog : all) {
            delete(blog);
        }
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public void deleteByName(String name) {
        log.info("delete by name  blog : " + name);
        blogRepository.deleteByName(name);
    }

    @Override
    public void save(Blog blog, int user_id) {
        log.info("save blog");
        List<Item> items = rssService.getItems(blog.getUrl(), blog.getName());
        if (items == null)
            throw new RssNewsNotFoundException(blog.getName());
        else
            blog.setItems(items);
        blogRepository.save(blog, user_id);
    }

    @Override
    public void update(Blog blog, int user_id) {
        log.info("update blog");
        blogRepository.save(blog, user_id);
    }

    @Override
    public List<Blog> findAllByUser(int user_id) {
        log.info("get all blogs by user");
        return blogRepository.getAllByUser(user_id);
    }

    @Override
    public void delete(int blog_id, int user_id) {
        log.info("delete blog");
        blogRepository.delete(blog_id, user_id);
    }

    @Override
    public List<Blog> getAll() {
        log.info("get all blogs");
        return blogRepository.getAll();
    }

    @Override
    public void update() {
        List<Blog> all = getAll();
        for (Blog blog : all) {
            List<Item> items = rssService.getItems(blog.getUrl(), blog.getName());
            if (items != null) {
                blog.setItems(items);
                blogRepository.save(blog, blog.getUser().getId());
            }
        }
    }


}
