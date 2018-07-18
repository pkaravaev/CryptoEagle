package com.cryptoeagle;

import com.cryptoeagle.RSS.ObjectFactory;
import com.cryptoeagle.RSS.TRss;
import com.cryptoeagle.RSS.TRssChannel;
import com.cryptoeagle.RSS.TRssItem;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.entity.test.BlogTest;
import com.cryptoeagle.entity.test.UserJpa;
import com.cryptoeagle.exception.RssException;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEnclosure;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class test {

    public static void main(String[] args) throws Exception {


        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(new URL("https://blog.ethereum.org/feed")));

        List<SyndEntry> list = feed.getEntries();

        for (SyndEntry entry : list){

            SyndContent description = entry.getDescription();

            Date date = entry.getPublishedDate();
            String value = description.getValue();
            String link = entry.getLink();
            String title = entry.getTitle();

            System.out.println();
        }


    }
}


