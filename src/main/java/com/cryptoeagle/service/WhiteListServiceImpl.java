package com.cryptoeagle.service;

import com.cryptoeagle.entity.WhiteList;
import com.cryptoeagle.repository.WhiteListRepository;
import com.cryptoeagle.service.abst.WhiteListService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class WhiteListServiceImpl implements WhiteListService {

    @Autowired
    WhiteListRepository repository;

    List<WhiteList> parseFromWeb() throws IOException {

        List<WhiteList> whiteLists = new ArrayList<>();
        Document document = Jsoup.connect("https://icodrops.com/whitelist/").get();
        Iterator<Element> iterator = document.select("div.whtico-row").iterator();

        while (iterator.hasNext()) {
            whiteLists.add(convertElementToWhitelist(iterator.next()));
        }
        return whiteLists;
    }

    @Override
    public List<WhiteList> getWhiteList() {
        return repository.getAll();
    }

    @Override
    public void updateWhitelist() {
        try {
            repository.save(parseFromWeb());
        } catch (IOException ex) {
            //TODO logging@!@
        }
    }

    private WhiteList convertElementToWhitelist(Element element) {

        String status = element.select("div.whitelist_date").first().childNode(0).toString();
        String name = element.select("div.whtico-row").first().select("div.white_info").first().childNode(1).childNode(0).childNode(0).toString();
        String category = element.select("div.whtico-row").first().select("div.white_info").select(".white-ico-category-name").first().childNode(0).toString();
        String logo = element.select("div.whtico-row").first().select("div.white_ico-icon").get(0).childNode(1).childNode(1).attr("data-src").toString();

        WhiteList whiteList = new WhiteList();

        whiteList.setStatus(status.replaceAll("\n", ""));
        whiteList.setName(name);
        whiteList.setLogo(logo);
        whiteList.setCategory(category);

        return whiteList;

    }
}
