package com.cryptoeagle.entity.crypto;

import com.cryptoeagle.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Getter
@Setter
@Entity
public class Team extends BaseEntity {

    private String name;
    private String title;
    private String links;
    private String url;
    private String photo;
}
