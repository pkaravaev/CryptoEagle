delete from users;
delete from blogs;

INSERT INTO users (  id_user, name, email, password, enable, admin) values
(100,'vasya','xxx@gmail.com', 'q1w2e3r4t5', true , false ),
(101,'pavel','fff@gmail.com', 'dsfsgds', true , false ),
(102,'sanya','dfdg@gmail.com', 'dsvcxb', true , false ),
(103,'ella','sgd@gmail.com' ,'sdrsr', true , true ),
(104,'anna', 'cgcg@gmail.com','sdgsdgds', true , false );

INSERT INTO blogs (id_blog,name,url,id_user) values
  (10001,'coinKate','coinkate.com',100),
  (10002,'marketcoin','marketcoin.com',100),
  (10003,'icoDrop','icoDrop.com',100),
  (10004,'coinup','coinup.com',101),
  (10005,'ethblog','ethblog.com',102),
  (10006,'XRP','XRP.com',103),
  (10007,'coinDown','coinDown.com',103);