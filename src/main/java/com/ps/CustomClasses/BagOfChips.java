package com.ps.CustomClasses;

public class BagOfChips extends Product {
    private String name;

    public BagOfChips(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
