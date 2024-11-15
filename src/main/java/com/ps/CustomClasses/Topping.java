package com.ps.CustomClasses;

public class Topping {
    private String name;
    private String type;
    private double basePrice;
    private double extrasBasePrice;


    public Topping(String name, String type) {
        this.name = name;
        this.type = type;

    }
    public Topping(String name){
        this.name = name;
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
    public double getExtrasPrice(String sandwichSize){
        if(type.equals("extra protein")){
            switch(sandwichSize){
                case "12 inch":
                    extrasBasePrice = 1.50;
                    break;
                case "8 inch":
                    extrasBasePrice = 1.00;
                    break;
                default:
                    extrasBasePrice = .50;
                    break;
            }
        } else if(type.equals("extra cheese")){
            switch (sandwichSize){
                case "12 inch":
                    extrasBasePrice = .90;
                    break;
                case "8 inch":
                    extrasBasePrice = .60;
                    break;
                default:
                    extrasBasePrice = .30;
            }
        } else {
            basePrice = 0;
        }
        return extrasBasePrice;

    }
 // create method for adding extra cheese and extra meat price similar to the getPrice
    // below and then loop through it in the sandwich class and add get the price there
    // and dont forget to pass the size of the sandwich

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
        return  getName();
    }
}
