package com.cryptoeagle;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;

public class TestData {
    // Users test data
    public static final AppUser USER1 = new AppUser(100, "username1", "user1@mail.ru", "user1password", true, false);
    public static final AppUser USER2 = new AppUser(101, "username2", "user2@mail.ru", "user2password", true, false);
    public static final AppUser USER3 = new AppUser(102, "username3", "user3@mail.ru", "user3password", true, true);
    public static final AppUser USER4 = new AppUser(103, "username4", "user4@mail.ru", "user4password", true, false);
    public static final AppUser USER5 = new AppUser(104, "username5", "user5@mail.ru", "user5password", true, false);


    public static final AppUser USER6 = new AppUser(105, "username6", "user6@mail.ru", "user6password", true, false);

    public static final AppUser USER4_UPDATE = new AppUser(103, "username4updated", "user4updated@mail.ru", "user4updatedpassword", false, false);

    public static final int USERS_COUNT = 5;


    //Blog test data
    public static final Blog BLOG1 = new Blog(1000, "user1_blog1", "user1_blog1.com");
    public static final Blog BLOG2 = new Blog(1001, "user1_blog2", "'user1_blog2.com");

    public static final Blog BLOG3 = new Blog(1002, "user2_blog1", "user2_blog1.com");
    public static final Blog BLOG4 = new Blog(1003, "user2_blog2", "user2_blog2.com");
    public static final Blog BLOG5 = new Blog(1004, "user2_blog3", "user2_blog3.com");

    public static final Blog BLOG6 = new Blog(1005, "user3_blog1", "user3_blog1.com");

    public static final Blog BLOG7 = new Blog(1006, "user4_blog1", "user4_blog1.com");
    public static final Blog BLOG8 = new Blog(1007, "user4_blog2", "user4_blog2.com");

    public static final Blog BLOG9 = new Blog(1008, "user5_blog1", "user5_blog1.com");

    public static final Blog BLOG3_UPDATE = new Blog("Blog3UPDATE", "Blog5UPDATE@.com");
    public static final int COUNT_BLOG = 5;


}
