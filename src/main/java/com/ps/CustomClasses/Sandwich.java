package com.ps.CustomClasses;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {
    private String breadType;
    private String size;
    private boolean isToasted;
    private boolean extraProtein;
    private boolean extraCheese;
    private double basePrice;
    List<Topping> toppings;
    List<Topping> extras;
    //lIST OF SAUCES
    // LIST OF SIDES

    public Sandwich(String breadType, String size, boolean isToasted, boolean extraProtein, boolean extraCheese) {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
        this.extras = new ArrayList<>();
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public void addExtras(Topping topping){
        extras.add(topping);
    }

    public boolean isToasted() {
        return  isToasted;
    }
    public String getIsToasted(){
        return isToasted ? "Toasted" : "Fresh";
    }

    public boolean isExtraProtein() {
        return extraProtein;
    }

    public void setExtraProtein(boolean extraProtein) {
        this.extraProtein = extraProtein;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }


    @Override
    public double getPrice() {

        if(this.size.equals("12 inch")){
            this.basePrice = 8.50;
        } else if( this.size.equals("8 inch")){
            this.basePrice = 7.00;
        } else {
            this.basePrice = 5.50;
        }
        for(Topping t : toppings){
           this.basePrice += t.getPrice(size);
        }
        if(isExtraProtein()){

        }


        return this.basePrice;
    }

    @Override
    public String toString() {
        return String.format("Sandwich: %s, %s, %s, Toppings: %s, Extras: %s", getBreadType(), getSize(), getIsToasted(), this.toppings, this.extras);
    }
}
