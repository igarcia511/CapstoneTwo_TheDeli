package com.ps.CustomClasses;

public class Topping  {
    private String name;
    private String type;
    private double basePrice;



    public Topping(String name, String type) {
        this.name = name;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice(){
        if(this.type.equals("Cheese")){
            basePrice =  .75;
        } else if(this.type.equals("Protein")){
            basePrice = 1.00;
        } else {
            basePrice = 0;
        }
return  basePrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
