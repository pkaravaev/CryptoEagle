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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class RssServiceImpl implements RssService {

    public List<Item> getItems(String url) {
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        List<Item> itemList = null;
        try {
            feed = input.build(new XmlReader(new URL(url)));
            List<SyndEntry> list = feed.getEntries();
            itemList = new ArrayList<>();
            for (SyndEntry entry : list) {
                SyndContent desc = entry.getDescription();

                Date date = entry.getPublishedDate();

                LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
                String description = desc.getValue();
                String link = entry.getLink();
                String title = entry.getTitle();


                Item item = new Item();
                item.setSource(Utils.cut(url));
//            item.setTitle(title.substring(0, title.length()).concat("..."));
                item.setTitle(Utils.clearString(title));
                item.setLink(link);
//            item.setDescription(description.substring(0, description.length() -1 ).concat("..."));
//            item.setDescription(Utils.clearString(description));
                item.setPublishDate(localDateTime);

                itemList.add(item);
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }

        return itemList;
    }

}