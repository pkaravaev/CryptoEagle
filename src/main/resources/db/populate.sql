delete from users;
delete from blogs;
delete from items;

INSERT INTO users (id_user, name, email, password, enable, admin) values
  (200, 'vasya', 'xxx@gmail.com', 'q1w2e3r4t5', true, false),
  (201, 'pavel', 'fff@gmail.com', 'dsfsgds', true, false),
  (202, 'sanya', 'dfdg@gmail.com', 'dsvcxb', true, false),
  (203, 'ella', 'sgd@gmail.com', 'sdrsr', true, true),
  (204, 'anna', 'cgcg@gmail.com', 'sdgsdgds', true, false);

INSERT INTO blogs (id_blog, name, url, id_user) values
  (10001, 'coinKate', 'coinkate.com', 200),
  (10002, 'marketcoin', 'marketcoin.com', 200),
  (10003, 'icoDrop', 'icoDrop.com', 200),
  (10004, 'coinup', 'coinup.com', 202),
  (10005, 'ethblog', 'ethblog.com', 202),
  (10006, 'XRP', 'XRP.com', 203),
  (10007, 'coinDown', 'coinDown.com', 203);

INSERT INTO items (id_item, title, description, publishdate, link, id_blog) values

  (100001, 'Crypto Mining Blog', 'All about BItcoin and Litecoin mining and other alternative crypto currencies, always be up to date with us.'
                                 ' This is a blog dedicated to crypto currency miners and users of Bitcoin (BTC), Litecoin (LTC), Ethereum (ETH) and other altcoins.',
   '2010/10/01', 'cryptomining-blog.com ', 10001),

  (100002, 'CCN | Bitcoin Mining', 'Updates and reports about the most recent Bitcoin mining news. At CCN we provide you with the latest Bitcoin news, including other cryptocurrencies like Ethereum, NEO, Litecoin and ICOs.
Frequency about 4 posts per week. ', '2010/10/01', 'ccn.com/bitcoin-mining ', 10001),

  (100003, '1st Mining Rig', 'Step by step tutorials with how to build and setup your first Ethereum (ETH) mining rig!!
Frequency about 3 posts per week.', '2010/10/03', '1stminingrig.com ', 10001),

  (100004, 'Genesis Mining Bitcoin Blog', 'Stay current with the bitcoin mining community and industry by reading from our library of bitcoin Blog posts. Check out our crypto mining blogs today!',
   '2010/10/05', 'blog.genesis-mining.com ', 10003),

  (100005, 'Bitcoin Mining | Everything you need to know about Bitcoin mining', 'Become the best Bitcoin miner and learn how to mine Bitcoins with the best Bitcoin mining hardware, software, pools and cloud mining.',
   '2010/10/01', 'bitcoinmining.com', 10003),

  (100006, 'CoinStaker | Cloud Mining Services Monitor', 'Latest Bitcoin and Cryptocurrency News. Read about everything from bitcoin block chain to cryptocurrency mining and trading. Each week we make a summary.',
   '2011/03/08', 'coinstaker.com ', 10005),

  (100007, 'Hashgains Blog | Bitcoin Cloud Mining', 'Hashgains provides the best Bitcoin and other Crypto currency cloud mining pool contracts that helps in mining the altcoins in the easiest way. Signup to start mining today.',
   '2012/01/03', 'hashgains.com/blog ', 10006),

  (100008, 'Hype.Codes', 'News dedicated to cryptocurrencies, crypto exchanges, blockchain technologies, ICO rates and mining', '2012/01/02', 'hype.codes ', 10006),

  (100009, 'Best GPU for Mining', 'Best gpu for mining in 2017. Follow our tests, read news, discover hashing power and power consumption of all the GPUs in the market',
   '2012/01/02', ' bestgpuformining.com', 10006),

  (100010, 'UK Bitcoin Blog | Bitcoins and Cryptocurrency News and Views', 'UK Bitcoin Blog, is a blog about Cryptocurrencies such as Bitcoin, Etherium, Dogecoin and Mining Bitcoins. Get Cryptocurrency News and Views from the UK
Frequency about 3 posts per month.', '2013/12/03', 'ukbitcoinblog.com/category/b.. ', 10007),

  (100011, 'Crypto Coin Mining Blog', 'Everything to do with crypto, from buying Bitcoin to setting up your new miners. We will try to cover anything to do with all cryptocurrencies.' ||
                                      ' Find what the next Bitcoin is or even find ways to get free crypto.', '2013/12/08', 'cryptocoinminingblog.com ', 10007),

  (100012, 'Helena Bitcoin Mining', 'Helena Bitcoin Mining, LLC ,a digital cryptocurrency mining company; Sharing the latest bitcoin news, bitcoin mining news & cryptocurrency industry updates.', '2014/10/03', 'helenabitcoinmining.com ', 10007);





