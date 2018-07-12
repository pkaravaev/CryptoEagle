package com.cryptoeagle;

import com.cryptoeagle.entity.Blog;

public class BlogTestData {

    public static Blog blog1 = new Blog("Dfssdf", "Fdsfds");



    public static Blog BLOG_UPDATE = new Blog(1002,"Vasya blog1", "blog99999.com");

   static  {

         BLOG_UPDATE.setAppUser(UserTestData.appUser1);
    }
}

