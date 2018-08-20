drop table if exists AppUser CASCADE;
drop table if exists Blog CASCADE;
-- drop table if exists Item CASCADE;
-- drop table if exists Role CASCADE;
-- drop sequence if exists global_seq;



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
  id         int4 not null,
  appUser_id int4,
  name       varchar(255),
  url        varchar(255),
  primary key (id),
  foreign key (appUser_id) references AppUser (id) ON DELETE CASCADE
);
--
-- create table Item (
--   id int4 not null,
--   description varchar(255),
--   link varchar(255),
--   title varchar(255),
--   blog_id int4,
--   primary key (id)
-- );
--
-- create table Role (
--   id int4 not null,
--   name varchar(255),
--   primary key (id)
-- );
--
-- create table Coin (
--   id int4 not null,
--   name varchar(255),
--   image varchar(255),
--   symbol varchar(10),
--   rank integer,
--   circulating_supply decimal,
--   price decimal,
--   volume_24h decimal,
--   market_cap decimal,
--   percent_change_1h decimal,
--   percent_change_7d decimal,
--   percent_change_24h decimal,
--
--   primary key (id)
-- );




