package com.ps.CustomClasses;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandwich extends Product {
    private String breadType;
    private String size;
    private boolean isToasted;
    private boolean extraProtein;
    private boolean extraCheese;
    private double basePrice;
    List<Topping> toppings;
    List<Topping> extras;
    List<Topping> sauces;
    List<Topping> sides;
    //lIST OF SAUCES
    // LIST OF SIDES

    public Sandwich(String breadType, String size, boolean isToasted, boolean extraProtein, boolean extraCheese) {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.extraProtein = extraProtein;
        this.extraCheese = extraCheese;
        this.toppings = new ArrayList<>();
        this.extras = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
    }

    public void addSide(Topping side) {
        sides.add(side);

    }

    public List<Topping> getSides() {
        return this.sides;
    }

    public void addSauce(Topping sauce) {
        sauces.add(sauce);

    }

    public List<Topping> getSauces() {
        return this.sauces;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public List<Topping> getToppings() {
        return this.toppings;
    }

    public void addExtras(Topping topping) {
        extras.add(topping);
    }

    public List<Topping> getExtras() {
        return this.extras;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public String getIsToasted() {
        return isToasted ? "toasted" : "fresh";
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

        if (this.size.equals("12 inch")) {
            this.basePrice = 8.50;
        } else if (this.size.equals("8 inch")) {
            this.basePrice = 7.00;
        } else {
            this.basePrice = 5.50;
        }
        for (Topping t : toppings) {
            this.basePrice += t.getPrice(size);
        }
        if (this.isExtraProtein()) {
            for (Topping t : extras) {
                if (t.getType().equals("extra protein")) {
                    this.basePrice += t.getExtrasPrice(size);
                }
            }
        }
        if (this.isExtraCheese()) {
            for (Topping t : extras) {
                if (t.getType().equals("extra cheese")) {
                    this.basePrice += t.getExtrasPrice(size);

                }
            }
        }


        return this.basePrice;
    }
  public String getSidesString(){
      String sideString = sides.stream()
              .map(Topping::toString)
              .collect(Collectors.joining(""));
      return sideString;
  }
    public String getSauceString() {
        String sauceString = sauces.stream()
                .map(Topping::toString)
                .collect(Collectors.joining(""));
        return sauceString;

    }

    public String getExtrasAsString() {
        String extraToppingsAsStrings = extras.stream()
                .map(Topping::toString)
                .collect(Collectors.joining(", "));
        return extraToppingsAsStrings;
    }

    public String getToppingsAsString() {
        String toppingsAsStrings = toppings.stream()
                .map(Topping::toString)
                .collect(Collectors.joining(", "));
        return toppingsAsStrings;
    }

    @Override
    public String toString() {
        String toppingsAsStrings = toppings.stream()
                .map(Topping::toString)
                .collect(Collectors.joining(","));

        String extraToppingsAsStrings = extras.stream()
                .map(Topping::toString)
                .collect(Collectors.joining(","));

        String sauceString = sauces.stream()
                .map(Topping::toString)
                .collect(Collectors.joining(""));

        String sideString = sides.stream()
                .map(Topping::toString)
                .collect(Collectors.joining(""));
        return String.format("Sandwich: %s, %s, %s, Toppings: %s, Extras: %s, Sauce: %s, Side: %s", getBreadType(), getSize(), getIsToasted(), toppingsAsStrings, extraToppingsAsStrings, sauceString, sideString);
    }
}
