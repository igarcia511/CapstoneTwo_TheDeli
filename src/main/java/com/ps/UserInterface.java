package com.ps;


import com.ps.CustomClasses.*;
import org.xml.sax.SAXNotSupportedException;

import java.util.*;

public class UserInterface {
    static Order order = new Order();
    private static Scanner commandScanner = new Scanner(System.in);
    private static Scanner inputScanner = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();

    public static void init() {
        display();
    }

    public static void display() {

        Product prodcut;
        Sandwich sandwich;

        int mainMenuCommand;

        do {
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.print("Selection: ");


                mainMenuCommand = commandScanner.nextInt();

                switch (mainMenuCommand) {
                    case 1:
                        handleNewOrder();
                        break;
                    case 0:
                        System.out.println("Exiting. . .");
                        break;
                    default:
                        System.out.println("Invalid command. . .");
                }

        } while (mainMenuCommand != 0);

    }

    private static void handleNewOrder() {
        int orderCommand;
        do {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Selection: ");


                orderCommand = commandScanner.nextInt();
                switch (orderCommand) {
                    case 1:
                        handleAddSandwich();
                        break;
                    case 2:
                        handleAddDrink();
                        break;
                    case 3:
                        handleAddChips();
                        break;
                    case 4:
                        handleCheckout();
                        break;
                    case 0:
                        handleCancelOrder();
                        break;
                    default:
                        System.out.println("Invalid input. . .");
                }




        } while (orderCommand != 0);
    }

    private static void handleAddSandwich() {
        Sandwich sandwich;
        HashMap<Integer, String> breadOptions = new HashMap<>();
        breadOptions.put(1, "white");
        breadOptions.put(2, "wheat");
        breadOptions.put(3, "rye");
        breadOptions.put(4, "wrap");

        System.out.println("What type of bread would you like?");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        int breadChoice = inputScanner.nextInt();

        System.out.println("Select your Sandwich size");
        System.out.println("1) 4 inch");
        System.out.println("2) 8 inch");
        System.out.println("3) 12 inch");

        int sandwichSize = inputScanner.nextInt();

        System.out.println("Would you like your sandwich toasted?");
        System.out.println("1) yes");
        System.out.println("2) no");

        int sandwichToastedOption = inputScanner.nextInt();
        boolean isToasted = sandwichToastedOption == 1;
        sandwich = new Sandwich(breadOptions.get(breadChoice), sandwichSize, isToasted);

        System.out.println("Topping selection");
        enum Protein {
            STEAK("steak"), HAM("ham"), SALAMI("salami"), ROAST_BEEF("roast beef"), CHICKEN("chicken"), BACON("bacon");
            private String name;

            Protein(String name) {
                this.name = name;
            }
        }

        enum Cheese {
            AMERICAN("american"), PROVOLONE("provolone"), SWISS("swiss"), CHEDDAR("cheddar");
            private String name;

            Cheese(String name) {
                this.name = name;
            }

        }
        //  lettuce peppers onions tomatoes jalepenos cucumbers pickles guacamole mushrooms
        enum Veggies {
            LETTUCE("lettuce"), PEPPERS("peppers"), ONIONS("onions"), TOMATOES("tomatoes"), JALAPENOS("jalapenos"), CUCUMBERS("cucumbers"), PICKLES("pickles"), GUACAMOLE("guacamole"), MUSHROOMS("mushrooms");
            private String name;

            Veggies(String name) {
                this.name = name;
            }
        }

        System.out.println("Choose a protein or enter 0 to skip");

        int index = 1;
        for(Protein p : Protein.values()){
            System.out.println(index + ") " + p.name);
            index++;
        }
        int proteinSelection = inputScanner.nextInt();
        // protein selection passed into add topping
        if(proteinSelection != 0){
            Protein proteinChoice = Protein.values()[proteinSelection - 1];
            sandwich.addTopping(proteinChoice.name);
        }
        inputScanner.nextLine();

        System.out.println("Choose a cheese or enter 0 to skip");
        index = 0;
        for(Cheese c : Cheese.values()){
            System.out.println(index + 1 + ") " + c.name);
            index++;
        }
        int cheeseSelection = inputScanner.nextInt();
        if(cheeseSelection != 0){
            Cheese cheeseChoice = Cheese.values()[cheeseSelection - 1];
            sandwich.addTopping(cheeseChoice.name);
        }

        System.out.println("Choose veggies, Enter 0) when done");
        while(true){
        int veggieSelection;
        index = 0;
        for (Veggies v : Veggies.values()) {

            System.out.println(index + ") " + v.name);
            index++;
        }

            veggieSelection = inputScanner.nextInt();
            if(veggieSelection == 0) break;
            Veggies veggieChoice = Veggies.values()[veggieSelection -1];
            sandwich.addTopping(veggieChoice.name);
        }



       Product product = sandwich;
       order.addProduct(product);



    }

    private static void handleAddDrink() {
        System.out.println("Add drink test");
    }

    private static void handleAddChips() {
        System.out.println("add chip test");
    }

    private static void handleCheckout() {
        System.out.println("display order");
        for(Product p : order.getProducts()){
            System.out.println(p);
        }
    }

    private static void handleCancelOrder() {
        //clear the array
        System.out.println("Canceling Order. . .");
    }

}

