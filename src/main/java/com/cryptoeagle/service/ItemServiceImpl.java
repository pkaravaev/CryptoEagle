package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.ItemRepository;
import com.cryptoeagle.service.abst.ItemService;
import com.cryptoeagle.service.abst.RssService;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
@EnableScheduling
public class ItemServiceImpl implements ItemService {

    private static final Logger log = Logger.getLogger(ItemServiceImpl.class.getName());

    @Autowired
    ItemRepository repository;

    @Autowired
    RssService service;

    public void ItemServiceImpl(ItemRepository repository, RssService service){
        this.repository =repository;
        this.service = service;
    }

    @Override
    public List<String> getSources() {
        return repository.getSources();
    }

    @Override
    public List<Item> getAll() {
        List<Item> itemList = repository.getall();
        return itemList;
    }

    @Override
    public List<Item> getBySource(String source) {
        return repository.getBySource(source);
    }

    @Override
    public void saveAndUpdate(Item item) {

    }

    @Override
    public void delete(int item) {

    }

    @Override
    public Item getByBlog(Blog blog) {
        return null;
    }

    @Scheduled(fixedDelay = 600000, initialDelay = 15000)
    public void updateItems() {

        repository.deleteAll();

        List<Item> items = service.getItems("https://www.coindesk.com/feed/");
        List<Item> items2 = service.getItems("https://www.ccn.com/feed/");
        List<Item> items3 = service.getItems("https://blog.blockchain.com/feed");
        List<Item> items4 = service.getItems("https://www.newsbtc.com/feed ");
        List<Item> items5 = service.getItems("https://blog.spectrocoin.com/en/feed");

        repository.saveAll(items5);
        repository.saveAll(items4);
        repository.saveAll(items3);
        repository.saveAll(items2);
        repository.saveAll(items);

        log.info("UPDATE ITEMS :" + LocalDateTime.now());

    }
}
