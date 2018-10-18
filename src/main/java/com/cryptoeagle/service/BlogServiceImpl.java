package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.exception.RssNewsNotFoundException;
import com.cryptoeagle.repository.BlogRepository;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.RssService;
import com.cryptoeagle.service.abst.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;


@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    BlogRepository blogRepository;

    RssService rssService;

    @Autowired
    UserService userService;


    @Autowired
    public BlogServiceImpl(RssService rssService, BlogRepository blogRepository) {
        this.rssService = rssService;
        this.blogRepository = blogRepository;
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    @Transactional
    public void delete(int blog_id) {
        log.info("delete blog : blog_id" + blog_id);
        Blog blog = blogRepository.getById(blog_id);
        User user = blog.getUser();
        user.getBlogs().remove(blog);
        delete(blog);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        log.info("delete by name  blog : " + name);
        Blog blog = blogRepository.getByName(name);
        User user = blog.getUser();
        user.getBlogs().remove(blog);
        delete(blog);
    }

    @Override
    @Transactional
    public void save(Blog blog, User user) {
        log.info("save blog : " + blog.getId());
        List<Item> items = rssService.getItems(blog.getUrl(), blog.getName());
        if (items == null) {
            log.error("RssNewsNotFoundException : ");
            throw new RssNewsNotFoundException(blog.getName());
        } else
            blog.setItems(items);

        if (!user.isNew())
            user = userService.get(user.getId());

        blog.setUser(user);
        user.getBlogs().add(blog);
        userService.saveAndUpdate(user);
    }

    @Override
    public List<Blog> findAllByUser(int user_id) {
        log.info("get all blogs by user :" + user_id);
        User user = userService.get(user_id);
        return user.getBlogs();
    }

    @Override
    @Transactional
    public Blog getByName(String name) {
        log.info("get blog by name  :" + name);
        Blog blog = blogRepository.getByName(name);
        return blogRepository.getByName(name);
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
                blogRepository.save(blog);
            }
        }
    }
}
