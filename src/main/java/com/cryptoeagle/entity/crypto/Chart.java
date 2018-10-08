package com.cryptoeagle.entity.crypto;


import lombok.Data;

@Data
public class Chart {

    private long x;

    private double[] y;

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public double[] getY() {
        return y;
    }

    public void setY(double[] y) {
        this.y = y;
    }
}
