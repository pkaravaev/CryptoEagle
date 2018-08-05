package com.cryptoeagle;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;

public class TestData {

    public static final Blog BLOG1 = new Blog(1,"Blog1","Blog1@.com");
    public static final Blog BLOG2 = new Blog(2,"Blog2","Blog2@.com");
    public static final Blog BLOG3 = new Blog(3,"Blog3","Blog3@.com");
    public static final Blog BLOG4 = new Blog(4,"Blog4","Blog4@.com");
    public static final Blog BLOG5 = new Blog(5,"Blog5","Blog5@.com");
    public static final Blog BLOG3_UPDATE = new Blog("Blog3UPDATE","Blog5UPDATE@.com");
    public static final int COUNT_BLOG = 5;

    public  static final AppUser USER1 = new AppUser();
    public  static final AppUser USER2 = new AppUser();
    public  static final AppUser USER3 = new AppUser();
    public  static final AppUser USER4 = new AppUser();
    public  static final AppUser USER5 = new AppUser();

}
