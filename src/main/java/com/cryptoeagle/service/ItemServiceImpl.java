package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.ItemRepository;
import com.cryptoeagle.service.abst.BlogService;
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
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
//@EnableScheduling
public class ItemServiceImpl implements ItemService {

    private static final Logger log = Logger.getLogger(ItemServiceImpl.class.getName());

    @Autowired
    ItemRepository repository;

    @Autowired
    BlogService blogService;

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
        List<Item> itemList = repository.getAll();
        return itemList;
    }

    @Override
    public List<Item> getBySource(String source) {
        return repository.getBySource(source);
    }


//    @Scheduled(fixedDelay = 600000, initialDelay = 15000)
    public void updateItems() {

        repository.deleteAll();

        List<Blog> allBlogs = blogService.getAll();
        if (allBlogs.size() > 0){
            Map<String, String> collect = allBlogs.stream().collect(Collectors.toMap(e -> e.getName(), e -> e.getUrl()));
            for(Map.Entry<String, String> map : collect.entrySet()){
                String name = map.getKey();
                String url = map.getValue();
                repository.saveAll( service.getItems(url, name));
            }

        }
        else {

            List<Item> items = service.getItems("https://cointelegraph.com/rss","cointelegraph");
            repository.saveAll(items);
        }

        log.info("UPDATE ITEMS :" + LocalDateTime.now());

    }
}
