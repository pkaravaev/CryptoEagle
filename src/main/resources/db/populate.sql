delete from users;
delete from blogs;
delete from items;

INSERT INTO users (id_user, name, email, password, enable, admin) values
  (100, 'vasya', 'xxx@gmail.com', 'q1w2e3r4t5', true, false),
  (101, 'pavel', 'fff@gmail.com', 'dsfsgds', true, false),
  (102, 'sanya', 'dfdg@gmail.com', 'dsvcxb', true, false),
  (103, 'ella', 'sgd@gmail.com', 'sdrsr', true, true),
  (104, 'anna', 'cgcg@gmail.com', 'sdgsdgds', true, false);

INSERT INTO blogs (id_blog, name, url, id_user) values
  (10001, 'coinKate', 'coinkate.com', 100),
  (10002, 'marketcoin', 'marketcoin.com', 100),
  (10003, 'icoDrop', 'icoDrop.com', 100),
  (10004, 'coinup', 'coinup.com', 101),
  (10005, 'ethblog', 'ethblog.com', 102),
  (10006, 'XRP', 'XRP.com', 103),
  (10007, 'coinDown', 'coinDown.com', 103);


INSERT INTO items (id_item, title, description, publishdate, link, id_blog) values
  (100001, 'news1', 'blbablabllaba', '2010/10/01', 'dsgdsgsdgdsgs.com', 10001),
  (100002, 'news2', 'blbablabllaba', '2010/10/01', 'dsgsd.com', 10001),
  (100003, 'news3', 'blbablabllaba', '2010/10/03', 'sdgds.com', 10001),
  (100004, 'news4', 'blbablabllaba', '2010/10/05', 'sgdsg.com', 10003),
  (100005, 'news5', 'blbablabllaba', '2010/10/01', 'dsgsdgdsg.com', 10003),
  (100006, 'news5', 'blbablabllaba', '2010/10/08', 'dsgdsgsdgdsgs.com', 10005),
  (100007, 'news6', 'blbablabllaba', '2010/10/01', 'cxbxbxb.com', 10006);




