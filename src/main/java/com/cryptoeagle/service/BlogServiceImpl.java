package com.cryptoeagle.service;

import com.cryptoeagle.AuthUser;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository repository;
    @Override
    public void save(Blog blog, String username) {
    }

    @Override
    public void update(Blog blog, String username) {

    }

    @Override
    public List<Blog> findall() {
       return repository.getall(AuthUser.USER_ID);
    }
}
