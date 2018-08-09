package com.cryptoeagle.service;


import com.cryptoeagle.Utils;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.service.abst.RssService;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class RssServiceImpl implements RssService {

    public List<Item> getItems(String url)  {
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        try {
            feed = input.build(new XmlReader(new URL(url)));
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
            item.setSource(Utils.cut(url));
            item.setTitle(title);
            item.setLink(link);
            item.setDescription(description);
            item.setPublishDate(date);

            itemList.add(item);
        }
        return itemList;
    }

}