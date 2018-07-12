insert
into
  AppUser
  (admin, email, enable, name, password, id)
values
  (true, 'pavel@mail.ru', true, 'Pavel', 'q1w2e3r4t5', 100),
  (false, 'vasya@mail.ru', true, 'Vasya', 'qwerty', 101),
  (false, 'alena@mail.ru', true, 'Alena', 'yuiop', 102);


insert
into
  Blog
  (appUser_id, name, url, id)
values
  (100, 'pavel blog1', 'gfdg', 1000),
  (100, 'pavel blog2', 'kjlk', 1001),
  (101, 'Vasya blog1', 'dsfsgd', 1002),
  (101, 'Vasya blog2', 'dsfsgd', 1003),
  (101, 'Vasya blog3', 'dsfsgd', 1004),
  (102, 'Alena blog1', 'cvx', 1005);


insert
into
  Item
  (blog_id, description, link, title, id)
values
  (1000, 'description', 'fefwef@cm', 'item1', 200),
  (1001, 'description2', 'dfgdfgf@cm', 'item2', 201),
  (1001, 'description3', 'fefwef@cm', 'item3', 202),
  (1002, 'description4', 'fefwef@cm', 'item4', 203);