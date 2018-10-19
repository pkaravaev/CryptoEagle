package com.cryptoeagle.service;


import com.cryptoeagle.Utils;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.exception.RssNewsNotFoundException;
import com.cryptoeagle.service.abst.RssService;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


@Service
@Slf4j
public class RssServiceImpl implements RssService {

    public Set<Item> getItems(String url, String source) {
        log.info("get items url : " + url + " source : " + source);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        Set<Item> itemSet = null;
        //TODO cut
        try {

            feed = input.build(new XmlReader(new URL(url)));
            List<SyndEntry> list = feed.getEntries();
            itemSet = new HashSet<>();
            for (SyndEntry entry : list) {
                SyndContent desc = entry.getDescription();

                Date date = entry.getPublishedDate();

                LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
                String description = desc.getValue();
                String link = entry.getLink();
                String title = entry.getTitle();

                Item item = new Item();
                item.setSource(source);
                item.setTitle(Utils.clearString(title));
                item.setLink(link);
                String plain = Jsoup.parse(description).text();

                if (plain.length() > 150) {
                    plain = plain.substring(0, 150);
                }

                item.setDescription(plain);
                item.setPublishDate(localDateTime);

                itemSet.add(item);
            }
        } catch (Exception e) {
            log.error(e.getMessage());

            return null;
//            throw new RssNewsNotFoundException("new not found");
        }

        return itemSet;
    }

}