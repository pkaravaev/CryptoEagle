

drop table if exists users;
drop sequence if exists global_seq;

CREATE SEQUENCE global_seq
  START 100000;


create table users (

  id       integer  primary key default nextval('global_seq'),
  name     varchar not null,
  password varchar not null,
  enable   boolean not null,
  admin    boolean not null

);

