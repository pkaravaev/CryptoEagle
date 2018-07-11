package com.cryptoeagle.entity;

import javax.persistence.*;


@MappedSuperclass
public abstract class BaseEntity {

    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNew(){
        return id == 0;
    }

    public BaseEntity(int id) {
        this.id = id;
    }
    public BaseEntity() {

    }
}
