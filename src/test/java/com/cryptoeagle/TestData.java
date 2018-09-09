package com.cryptoeagle;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.entity.Blog;

public class TestData {
    // Users test data
    public static final User USER1 = new User(100, "username1", "user1@mail.ru", "user1password", true);
    public static final User USER2 = new User(101, "username2", "user2@mail.ru", "user2password", true);
    public static final User USER3 = new User(102, "username3", "user3@mail.ru", "user3password", true);
    public static final User USER4 = new User(103, "username4", "user4@mail.ru", "user4password", true );
    public static final User USER5 = new User(104, "username5", "user5@mail.ru", "user5password", true);

    public static final User USER6 = new User(105, "username6", "user6@mail.ru", "user6password", true);

    public static final User USER4_UPDATE = new User(103, "username4updated", "user4updated@mail.ru", "user4updatedpassword",true);

    public static final int USERS_COUNT = 5;


    //Blog test data
    public static final Blog BLOG1 = new Blog(1000, "user1_blog1", "user1_blog1.com", USER1);
    public static final Blog BLOG2 = new Blog(1001, "user1_blog2", "'user1_blog2.com", USER1);

    public static final Blog BLOG3 = new Blog(1002, "user2_blog1", "user2_blog1.com", USER2);
    public static final Blog BLOG4 = new Blog(1003, "user2_blog2", "user2_blog2.com", USER2);
    public static final Blog BLOG5 = new Blog(1004, "user2_blog3", "user2_blog3.com", USER2);

    public static final Blog BLOG6 = new Blog(1005, "user3_blog1", "user3_blog1.com", USER3);

    public static final Blog BLOG7 = new Blog(1006, "user4_blog1", "user4_blog1.com", USER4);
    public static final Blog BLOG8 = new Blog(1007, "user4_blog2", "user4_blog2.com", USER4);

    public static final Blog BLOG9 = new Blog(1008, "user5_blog1", "user5_blog1.com", USER5);


    public static final Blog BLOG10 = new Blog(1009, "blog6", "blog6.com");

    public static final Blog BLOG3_UPDATE = new Blog(1005, "Blog3UPDATE", "Blog5UPDATE@.com");

    static {

        BLOG3_UPDATE.setUser(USER3);
    }

    public static final int BLOG_COUNT = 9;


}
