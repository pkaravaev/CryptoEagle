package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.ItemRepository;
import com.cryptoeagle.service.abst.ItemService;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    ItemRepository repository;

    @Override
    public List<Item> findall() {
//        log.info("Get all items");
//        return repository.getall();

        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        try {
            feed = input.build(new XmlReader(new URL("https://www.coindesk.com/feed/")));
        } catch (Exception e) {
        }

        List<SyndEntry> list = feed.getEntries();
        List<Item> itemList = new ArrayList<>();
        for (SyndEntry entry : list) {

            SyndContent desc = entry.getDescription();

            Date date = entry.getPublishedDate();
            String description = desc.getValue();
            String link = entry.getLink();
            String title = entry.getTitle();

            Item item = new Item();
            item.setTitle(title);
            item.setLink(link);
            item.setDescription(description);
            item.setPublishDate(date);

            itemList.add(item);
        }

        return itemList;
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
}
