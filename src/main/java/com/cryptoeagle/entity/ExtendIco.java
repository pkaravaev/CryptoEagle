package com.cryptoeagle.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Map;

@Entity
@Embeddable
public class ExtendIco extends Ico {
    @Id
    private int id;
    @ElementCollection
    private Map<String,String> links;
    @ElementCollection
    private Map<String,String> finance;
    @ElementCollection
    private Map<String,String> categories;
    @ElementCollection
    private Map<String,String> team;

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
        this.links = links;
    }

    public Map<String, String> getFinance() {
        return finance;
    }

    public void setFinance(Map<String, String> finance) {
        this.finance = finance;
    }

    public Map<String, String> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, String> categories) {
        this.categories = categories;
    }

    public Map<String, String> getTeam() {
        return team;
    }

    public void setTeam(Map<String, String> team) {
        this.team = team;
    }
}
