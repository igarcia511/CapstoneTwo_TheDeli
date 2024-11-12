package com.ps.CustomClasses;

public class Drink extends Product {
    private String name;
    private int size;
    private double basePrice;

    public Drink(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }
    public String getStringSize(){
        if(size == 1){
            return "Large";
        } else if(size == 2){
            return "Medium";
        }   else {
            return "Small";
        } }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        if(this.size == 1){
            basePrice = 3.00;
        } else if( this.size == 2){
            basePrice = 2.50;
        } else {
            basePrice = 2.00;
        }
        return basePrice;

    }

    @Override
    public String toString() {
        return "Drink: " + name + ", Size: " + getStringSize();
    }
}
