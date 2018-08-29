package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.BlogRepository;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service
public class BlogServiceImpl implements BlogService {

    private static final Logger log = Logger.getLogger(BlogServiceImpl.class.getName());

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    RssService rssService;

    @Override
    public void deleteByName(String name) {
        log.info("delete by name  blog : " + name);
        blogRepository.deleteByName(name);
    }

    @Override
    public void save(Blog blog, int user_id) {
        log.info("save blog");
        blogRepository.save(blog, user_id);
    }

    @Override
    public void update(Blog blog, int user_id) {
        log.info("update blog");
        blogRepository.save(blog, user_id);
    }

    @Override
    public List<Blog> findall(int user_id) {
        log.info("get all blogs by user");
      return blogRepository.getallByUser(user_id);
    }

    @Override
    public List<Item> itemsFromBlogs(int user_id) {
        return null;
    }

    @Override
    public void delete(int blog_id, int user_id) {
        log.info("delete blog");
        blogRepository.delete(blog_id,user_id);
    }

    @Override
    public List<Blog> getAll() {
        log.info("get all blogs");
        return blogRepository.getAll();
    }

    @Override
    public void updateFromRss() {
        List<Blog> all = blogRepository.getAll();
        for (Blog blog : all){
            List<Item> items = rssService.getItems(blog.getUrl());
            if (items != null) {
                blog.setItems(items);
                blogRepository.save(blog, blog.getUser().getId());
            }
        }
    }
}
