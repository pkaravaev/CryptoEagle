package com.cryptoeagle.entity.crypto;


import com.cryptoeagle.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Exchange extends BaseEntity {

    private String price;
    private String name;
    private String logo;
    private String currency;
    private  String roi;

}
