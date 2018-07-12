drop table if exists AppUser CASCADE;
drop table if exists Blog CASCADE;
drop table if exists Item CASCADE;
drop table if exists Role CASCADE;
drop sequence if exists global_seq;



CREATE SEQUENCE global_seq
  START 100000;

create table AppUser (
  id int4 not null,
  admin boolean not null,
  email varchar(255),
  enable boolean not null,
  name varchar(255),
  password varchar(255),
  primary key (id)
);

create table Blog (
  id int4 not null,
  name varchar(255),
  url varchar(255),
  appUser_id int4,
  primary key (id)
);

create table Item (
  id int4 not null,
  description varchar(255),
  link varchar(255),
  title varchar(255),
  blog_id int4,
  primary key (id)
);

create table Role (
  id int4 not null,
  name varchar(255),
  primary key (id)
);



