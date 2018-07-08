drop table if exists users CASCADE;
drop table if exists blogs CASCADE;
drop table if exists items CASCADE;
drop sequence if exists global_seq;



CREATE SEQUENCE global_seq
  START 100000;

create table users (

  id_user  int primary key,
  name     varchar(30) not null,
  email    varchar(150) not null,
  password varchar(20) not null,
  enable   boolean     not null,
  admin    boolean     not null

);

create table blogs (
  id_blog integer primary key,
  name    varchar(20) not null,
  url     varchar(150) not null,
  id_user int REFERENCES users (id_user) ON DELETE CASCADE
);


create table items (
  id_item integer primary key,
  title    varchar(50) not null,
  description varchar(300) not null,
  publishdate TIMESTAMP not null ,
  link varchar(100) not null ,

  id_blog int REFERENCES blogs (id_blog) ON DELETE CASCADE
);


