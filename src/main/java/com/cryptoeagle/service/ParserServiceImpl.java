package com.cryptoeagle.service;

import com.cryptoeagle.entity.WhiteList;
import com.cryptoeagle.service.abst.ParserService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ParserServiceImpl implements ParserService {

    @Override
    public List<WhiteList> getWhiteList() {

        List<WhiteList> whiteLists = null;

        try {

            Document document = Jsoup.connect("https://icodrops.com/whitelist/").get();

            Iterator<Element> iterator = document.select("div.whtico-row").iterator();

            whiteLists = new ArrayList<>();

            while (iterator.hasNext()) {

                Element next = iterator.next();

                String status = next.select("div.whitelist_date").first().childNode(0).toString();
                String name = next.select("div.whtico-row").first().select("div.white_info").first().childNode(1).childNode(0).childNode(0).toString();
                String category = next.select("div.whtico-row").first().select("div.white_info").select(".white-ico-category-name").first().childNode(0).toString();
                String logo = next.select("div.whtico-row").first().select("div.white_ico-icon").get(0).childNode(1).childNode(1).attr("data-src").toString();

                WhiteList whiteList = new WhiteList();

                whiteList.setStatus(status.replaceAll("\n",""));
                whiteList.setName(name);
                whiteList.setLogo(logo);
                whiteList.setCategory(category);

                whiteLists.add(whiteList);
            }

        } catch (Exception ex) {
            return whiteLists;
        }
        return whiteLists;
    }
}
