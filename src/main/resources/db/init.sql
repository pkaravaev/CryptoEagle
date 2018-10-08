DROP sequence IF EXISTS global_seq;

DROP table IF EXISTS appuser CASCADE ;
DROP table IF EXISTS appuser_UserRole CASCADE;
DROP table IF EXISTS Blog_Item CASCADE;
DROP table IF EXISTS Blog CASCADE;
DROP table IF EXISTS Coin CASCADE;
DROP table IF EXISTS Event CASCADE;
DROP table IF EXISTS Exchange CASCADE;
DROP table IF EXISTS Ico CASCADE;
DROP table IF EXISTS Idata CASCADE;
DROP table IF EXISTS Idata_categories CASCADE;
DROP table IF EXISTS Idata_Exchange CASCADE;
DROP table IF EXISTS Idata_finance CASCADE;
DROP table IF EXISTS Idata_links CASCADE;
DROP table IF EXISTS Idata_Team CASCADE;
DROP table IF EXISTS Idata_links CASCADE;
DROP table IF EXISTS Item CASCADE;
DROP table IF EXISTS Team CASCADE;
DROP table IF EXISTS UserRole CASCADE;
DROP table IF EXISTS WhiteList CASCADE;

create sequence global_seq
  start 100000
  increment 1;

create table appuser (
  id       int4    not null,
  admin    boolean not null,
  email    varchar(255),
  enable   boolean not null,
  name     varchar(5),
  password varchar(255),
  primary key (id)
);

create table appuser_UserRole (
  User_id     int4 not null,
  userRole_id int4 not null,
  primary key (User_id, userRole_id)
);

create table Blog (
  id      int4         not null,
  name    varchar(255) not null,
  url     varchar(255) not null,
  user_id int4         not null,
  primary key (id)
);

create table Blog_Item (
  Blog_id  int4 not null,
  items_id int4 not null
);

create table Coin (
  id                 int4           not null,
  circulating_supply numeric(19, 2) not null,
  dataAvailable      boolean        not null,
  image              varchar(255),
  market_cap         numeric(19, 2) not null,
  name               varchar(255),
  percent_change_1h  float8         not null,
  percent_change_24h float8         not null,
  percent_change_7d  float8         not null,
  price              float8         not null,
  rank               int4           not null,
  symbol             varchar(255),
  volume_24h         numeric(19, 2) not null,
  primary key (id)
);

create table Event (
  id          int4         not null,
  coinName    varchar(255) not null,
  date_event  timestamp    not null,
  description varchar(255) not null,
  isHot       boolean      not null,
  name        varchar(255) not null,
  proof       varchar(255) not null,
  source      varchar(255) not null,
  title       varchar(255),
  twitter     varchar(255) not null,
  primary key (id)
);

create table Exchange (
  id       int4 not null,
  currency varchar(255),
  logo     varchar(255),
  name     varchar(255),
  price    varchar(255),
  roi      varchar(255),
  primary key (id)
);

create table Ico (
  id           int4         not null,
  description  varchar(255) not null,
  icoEnd       timestamp,
  icoStart     timestamp,
  logolink     varchar(255),
  name         varchar(255),
  page         int4         not null,
  preIcoEnd    timestamp,
  preIcoStart  timestamp,
  rating       float8       not null,
  website_link varchar(255) not null,
  data_id      int4,
  primary key (id)
);

create table Idata (
  id    int4 not null,
  intro varchar(1024),
  primary key (id)
);

create table Idata_categories (
  Idata_id       int4         not null,
  categories     varchar(255),
  categories_KEY varchar(255) not null,
  primary key (Idata_id, categories_KEY)
);

create table Idata_Exchange (
  Idata_id     int4 not null,
  exchanges_id int4 not null,
  primary key (Idata_id, exchanges_id)
);

create table Idata_finance (
  Idata_id    int4         not null,
  finance     varchar(255),
  finance_KEY varchar(255) not null,
  primary key (Idata_id, finance_KEY)
);

create table Idata_links (
  Idata_id  int4         not null,
  links     varchar(255),
  links_KEY varchar(255) not null,
  primary key (Idata_id, links_KEY)
);

create table Idata_Team (
  Idata_id int4 not null,
  crew_id  int4 not null,
  primary key (Idata_id, crew_id)
);

create table Item (
  id          int4         not null,
  description varchar(255) not null,
  link        varchar(255) not null,
  publishDate timestamp    not null,
  source      varchar(255) not null,
  title       varchar(255) not null,
  primary key (id)
);

create table Team (
  id    int4 not null,
  links varchar(255),
  name  varchar(255),
  photo varchar(255),
  title varchar(255),
  url   varchar(255),
  primary key (id)
);

create table UserRole (
  id   int4 not null,
  role varchar(255),
  primary key (id)
);

create table WhiteList (
  id       int4 not null,
  category varchar(255),
  logo     varchar(255),
  name     varchar(255),
  status   varchar(255),
  primary key (id)
);




alter table appuser
  add constraint UK_hcij6hlq32eras7xlmvbx2sbm unique (email);


alter table appuser
  add constraint UK_ee3cmxp6jvhe7rqksp12a80w5 unique (name);


alter table appuser_UserRole
  add constraint UK_h2txosrj3piy8j483q9e59sci unique (userRole_id);


alter table Blog
  add constraint UK_40tvjgj9hcufyefk7w0x4edmg unique (name);


alter table Blog
  add constraint UK_sbwxdwftwe78l1cqba42g73a7 unique (url);


alter table Blog_Item
  add constraint UK_g5hofsrmhtrnmv9uc3bvx8ouk unique (items_id);


alter table Coin
  add constraint UK_t5dk6mtph8m328rejpscb0jym unique (name);


alter table Coin
  add constraint UK_okchk4xbrpoc9nh4k7tn0pk85 unique (symbol);


alter table Event
  add constraint UK_p5m91ptppqxy57n6m7epv617a unique (title);


alter table Ico
  add constraint UK_od5gb62vqnwpmfr3p9auog8ty unique (logolink);


alter table Ico
  add constraint UK_qjrh8xnyqfghcn8fht7xayq7a unique (name);

alter table Idata_Exchange
  add constraint UK_pr5jjq73wywkvl8hcm4x4kgc7 unique (exchanges_id);


alter table Idata_Team
  add constraint UK_m54pmpoi5i5xq9ib3w2orqpjo unique (crew_id);


alter table Item
  add constraint UK_dp2x1lasb798ua1955wpae6ac unique (title);


alter table appuser_UserRole
  add constraint FKjtqofmmuhcs4ctgdyswjcqteg
foreign key (userRole_id)
references UserRole;


alter table appuser_UserRole
  add constraint FK8bkw3m2bwgc098ntcfo2drr3g
foreign key (User_id)
references appuser;


alter table Blog
  add constraint FKsuo4b2bvbco37ao6ynjiovnqp
foreign key (user_id)
references appuser;


alter table Blog_Item
  add constraint FKhvbfmnvy55b7ggk6999gcbi2a
foreign key (items_id)
references Item;


alter table Blog_Item
  add constraint FK32f389j6v0x6d8xqljyq497i6
foreign key (Blog_id)
references Blog;


alter table Ico
  add constraint FKn3q5g8467sfgpxcp8oefkhjci
foreign key (data_id)
references Idata;


alter table Idata_categories
  add constraint FK4amyxd29o6yxcglwmqadiand1
foreign key (Idata_id)
references Idata;


alter table Idata_Exchange
  add constraint FKqxi2pb5ni8nc4h43dgd0pd5wb
foreign key (exchanges_id)
references Exchange;


alter table Idata_Exchange
  add constraint FKas333s7xfmjti190sdwu4vmbh
foreign key (Idata_id)
references Idata;


alter table Idata_finance
  add constraint FKje5voghrihjjg2ty1gcr3gnul
foreign key (Idata_id)
references Idata;


alter table Idata_links
  add constraint FKr2xumhindlpg5sn0cw9uuomry
foreign key (Idata_id)
references Idata;


alter table Idata_Team
  add constraint FKmnvxpqq81vwdvhb6ttyujepx6
foreign key (crew_id)
references Team;


alter table Idata_Team
  add constraint FKbfv0cfxpnk026vevjmj7fha1t
foreign key (Idata_id)
references Idata;