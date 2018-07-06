package com.cryptoeagle.entity;

public abstract class BaseEntity {

    private int id;

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
