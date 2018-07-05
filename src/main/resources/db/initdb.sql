drop table if exists users;
drop table if exists blogs;
drop sequence if exists global_seq;

CREATE SEQUENCE global_seq
  START 100000;


create table users (

  id_user  int primary key ,
  name     varchar(20) not null,
  email    varchar(20) not null,
  password varchar(20) not null,
  enable   boolean     not null,
  admin    boolean     not null

);

create table blogs (
  id_blog integer primary key ,
  name    varchar(20) not null,
  url     varchar (20) not null,
  id_user int REFERENCES users (id_user)
);

