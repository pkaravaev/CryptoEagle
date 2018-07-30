package com.cryptoeagle.entity.crypto;

import com.cryptoeagle.entity.BaseEntity;
import com.cryptoeagle.entity.Ico;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


@Entity
public class Idata extends BaseEntity {

    @ElementCollection
    private Map<String, String> links = new HashMap<>();
    @ElementCollection
    private Map<String, String> finance= new HashMap<>();
    @ElementCollection
    private Map<String, String> categories= new HashMap<>();
    @ElementCollection
    private Map<String, String> team= new HashMap<>();
    @ElementCollection
    private Map<String, String> exchanges= new HashMap<>();


    public void setLink(String link, String value) {
        links.put(link, value);
    }

    public void setFinance(String link, String value) {
        finance.put(link, value);
    }

    public void setCategories(String link, String value) {
        categories.put(link, value);
    }

    public void setTeam(String link, String value) {
        team.put(link, value);
    }

    public void setExchanges(String link, String value) {
        exchanges.put(link, value);
    }

    public String getLink(String link) {
        return links.get(link);
    }

    public String getFinance(String link) {
        return finance.get(link);
    }

    public String getCategories(String link) {
        return categories.get(link);
    }

    public String getTeam(String link) {
        return team.get(link);
    }

    public String getExchanges(String link) {
        return exchanges.get(link);
    }
}