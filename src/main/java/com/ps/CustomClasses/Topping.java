package com.ps.CustomClasses;

public class Topping {
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


    public double getPrice(String sandwichSize) {
          if(type.equals("Protein")){
              switch(sandwichSize){
                  case "12 inch":
                      basePrice = 3.00;
                      break;
                  case "8 inch":
                      basePrice = 2.00;
                      break;
                  default:
                      basePrice = 1.00;
                      break;
              }
          } else if(type.equals("Cheese")){
              switch (sandwichSize){
                  case "12 inch":
                      basePrice = 2.25;
                      break;
                  case "8 inch":
                      basePrice = 1.50;
                      break;
                  default:
                      basePrice = .75;
              }
          } else {
              basePrice = 0;
          }
        return basePrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
