package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Item;

import javax.xml.transform.Source;
import java.io.File;
import java.util.List;
import java.util.Set;

public interface RssService {


    Set<Item> getItems(String url, String source);


}
