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
  (100, 'pavelblog1', 'blog1.com', 1000),
  (100, 'pavelblog2', 'blog2.com', 1001),
  (101, 'Vasyablog1', 'blog1.com', 1002),
  (101, 'Vasyablog2', 'blog2.com', 1003),
  (101, 'Vasyablog3', 'blog3.com', 1004),
  (102, 'Alenablog1', 'blog1.com', 1005);


insert
into
  Item
  (blog_id, description, link, title, id)
values
  (1000, 'illionaire investor Steven Cohen, once dubbed the "Hedge Fund King," has reportedly entered the crypto space.
According to a Fortune article published July 12', 'https://www.coindesk.com', 'Hedge Fund Billionaire Steven Cohen Is Getting into Crypto', 200),

  (1000, 'Bitcoin (BTC) may be up slightly at the start of Friday''s session, but it remains to be seen if it can build traction above $6,000.', 'www.coindesk.com', 'Bitcoin Price Defends $6K As Upside Potential Builds', 201),
  (1000, 'Local police officials in China seized more than $1.5 million worth of cryptocurrencies as part of a crackdown on gambling during the 2018 FIFA World Cup', 'www.coindesk.com', 'Police Seize $1.5 Million in Crypto During FIFA Gambling Crackdown', 202),
  (1001, 'The slight increase in the price of bitcoin from $6,070 to $6,250 has allowed the dominant cryptocurrency to break out of a descending trendline since July 10,', 'www.ccn.com', 'Bitcoin Price Avoids Decline to $6,000 but Crypto Market Still in Downtrend', 203),
  (1002, 'In April, the Reserve Bank of India (RBI) issued a banking ban on cryptocurrency trading and use. This ban prohibits banks', 'www.crypto-news.net', 'Indian Crypto Usage Growing Despite RBI Ban', 204),
  (1002, 'Suicides are a wake-up call: Kate Spade and Anthony Bourdain were successful and wealthy—just like so many top advisors’ clients.', 'www.newsnow.co.uk', 'Week’s Best: Suicide, Supreme Court, Bitcoin', 205),
  (1004, 'The definition of a cryptocurrency is a digital currency built with cryptographic protocols that make transactions secure and difficult to fake', 'cointelegraph.com', 'Cryptocurrencies News', 206),
  (1005, 'The market declines that have affected cryptocurrencies this year have prompted many traders to express concern about the future value of the technology,', 'www.crypto-news.net', 'nstitutional Investment In Cryptocurrencies Growing Despite Price Volatility', 207);