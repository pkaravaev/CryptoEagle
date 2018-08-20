package com.cryptoeagle;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;

public class TestData {

    public  static final AppUser USER1 = new AppUser( 100,"username1", "user1@mail.ru","user1password", true,false);
    public  static final AppUser USER2 =  new AppUser(101,"username2", "user2@mail.ru","user2password", true,false);
    public  static final AppUser USER3 = new AppUser(102,"username3", "user3@mail.ru","user3password", true,true);
    public  static final AppUser USER4 =  new AppUser(103,"username4", "user4@mail.ru","user4password", true,false);
    public  static final AppUser USER5 =  new AppUser(104,"username5", "user5@mail.ru","user5password", true,false);


    public  static final AppUser USER6 =  new AppUser(105,"username6", "user6@mail.ru","user6password", true,false);

    public  static final AppUser USER4_UPDATE =  new AppUser(103,"username4updated", "user4updated@mail.ru","user4updatedpassword", false,false);

    public  static final int USERS_COUNT = 5;




    public static final Blog BLOG1 = new Blog(1,"Blog1","Blog1@.com");
    public static final Blog BLOG2 = new Blog(2,"Blog2","Blog2@.com");
    public static final Blog BLOG3 = new Blog(3,"Blog3","Blog3@.com");
    public static final Blog BLOG4 = new Blog(4,"Blog4","Blog4@.com");
    public static final Blog BLOG5 = new Blog(5,"Blog5","Blog5@.com");
    public static final Blog BLOG3_UPDATE = new Blog("Blog3UPDATE","Blog5UPDATE@.com");
    public static final int COUNT_BLOG = 5;


}
