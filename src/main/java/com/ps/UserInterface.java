package com.ps;


import com.ps.CustomClasses.*;
import org.xml.sax.SAXNotSupportedException;

import java.util.*;

public class UserInterface {
    static Order order;
    private static Scanner commandScanner = new Scanner(System.in);
    private static Scanner inputScanner = new Scanner(System.in);
    private static int orderIndexId;

    public static void init() {
        display();
    }

    public static void display() {


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
        ++orderIndexId;
        System.out.print("Enter the name for the order: ");
        String orderName = inputScanner.nextLine();
        order = new Order(orderName, orderIndexId);
        do {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");

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
                default:
                    System.out.println("Invalid input. . .");
            }


        } while (orderCommand != 4);
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
        System.out.print("Selection: ");
        int breadChoice = inputScanner.nextInt();
        HashMap<Integer, String> breadSize = new HashMap<>();
        breadSize.put(1, "4 inch");
        breadSize.put(2, "8 inch");
        breadSize.put(3, "12 inch");

        System.out.println("Select your Sandwich size");
        System.out.println("1) 4 inch");
        System.out.println("2) 8 inch");
        System.out.println("3) 12 inch");
        System.out.print("Selection: ");

        int sandwichSize = inputScanner.nextInt();


        System.out.println("Would you like your sandwich toasted?");
        System.out.println("1) yes");
        System.out.println("2) no");
        System.out.print("Selection: ");

        int sandwichToastedOption = inputScanner.nextInt();
        boolean isToasted = sandwichToastedOption == 1;
        sandwich = new Sandwich(breadOptions.get(breadChoice), breadSize.get(sandwichSize), isToasted, false, false);

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
        for (Protein p : Protein.values()) {
            System.out.println(index + ") " + p.name);
            index++;
        }
        System.out.print("Selection: ");
        int proteinSelection = inputScanner.nextInt();
        // protein selection passed into add topping
        if (proteinSelection != 0) {
            Protein proteinChoice = Protein.values()[proteinSelection - 1];
            sandwich.addTopping(new Topping(proteinChoice.name, "Protein"));

            System.out.println("Would you like to add an extra protein? 1) yes 2) no ");
            System.out.print("Selection: ");

            int extraProteinSelection = inputScanner.nextInt();
            boolean wantsExtraProtein = extraProteinSelection == 1;
            if (wantsExtraProtein) {
                int extraProteinIndex = 1;
                for (Protein p : Protein.values()) {
                    System.out.println(extraProteinIndex + ") " + p.name);
                    extraProteinIndex++;
                }
                System.out.print("Selection: ");
                int extraProteinChoice = inputScanner.nextInt();
                Protein extraProtein = Protein.values()[extraProteinChoice - 1];
                sandwich.addExtras(new Topping(extraProtein.name, "extra protein"));
                sandwich.setExtraProtein(true);
            }

        }
        inputScanner.nextLine();

        System.out.println("Choose a cheese or enter 0 to skip");
        index = 1;
        for (Cheese c : Cheese.values()) {
            System.out.println(index + ") " + c.name);
            index++;
        }
        System.out.print("Selection: ");
        int cheeseSelection = inputScanner.nextInt();
        if (cheeseSelection != 0) {
            Cheese cheeseChoice = Cheese.values()[cheeseSelection - 1];
            sandwich.addTopping(new Topping(cheeseChoice.name, "Cheese"));

            System.out.println("Would you like to add extra cheese? 1) yes 2) no");
            System.out.print("Selection: ");
            int extraCheeseSelection = inputScanner.nextInt();
            boolean wantsExtraCheese = extraCheeseSelection == 1;

            if (wantsExtraCheese) {
                int cheeseSelectionIndex = 1;
                for (Cheese c : Cheese.values()) {
                    System.out.println(cheeseSelectionIndex + ") " + c.name);
                    cheeseSelectionIndex++;
                }
                System.out.print("Selection: ");
                int extraCheeseChoice = inputScanner.nextInt();
                Cheese extraCheese = Cheese.values()[extraCheeseChoice - 1];
                sandwich.addExtras(new Topping(extraCheese.name, "extra cheese"));
                sandwich.setExtraCheese(true);
            }

        }


        System.out.println("Choose veggies");
        while (true) {
            int veggieSelection;
            index = 1;
            for (Veggies v : Veggies.values()) {

                System.out.println(index + ") " + v.name);
                index++;
            }
            System.out.println("Enter 0) when done selecting veggies");
            System.out.print("Selection: ");
            veggieSelection = inputScanner.nextInt();
            if (veggieSelection == 0) break;
            Veggies veggieChoice = Veggies.values()[veggieSelection - 1];
            sandwich.addTopping(new Topping(veggieChoice.name, "Veggies"));
        }

        HashMap<Integer, String> sauces = new HashMap<>();
        sauces.put(1, "mayo");
        sauces.put(2, "ketchup");
        sauces.put(3, "mustard");
        sauces.put(4, "ranch");
        sauces.put(5, "thousand island");
        sauces.put(6, "vinaigrette");


        System.out.println("Select a sauce or enter 0) to skip");
        for(Integer key : sauces.keySet()){
            System.out.println(key + ")" + sauces.get(key));
        }
        System.out.print("Selection: ");
        int sauceSelection = inputScanner.nextInt();
        if(sauceSelection > 0 && sauces.containsKey(sauceSelection)){
            sandwich.addSauce(new Topping(sauces.get(sauceSelection)));
        } else if(sauceSelection == 0){
            System.out.println("No sauce selected...");
        }

        System.out.println("Select your side or enter 0) to skip");
        HashMap<Integer, String> sides = new HashMap<>();
        sides.put(1, "au jus");

        System.out.println("1) au jus");
        int sideSelection = inputScanner.nextInt();
        boolean sideChoice = sideSelection == 1;
        if(sideChoice){
            sandwich.addSide(new Topping(sides.get(sideSelection)));
        }

        Product product = sandwich;

        order.addProduct(product);


    }

    private static void handleAddDrink() {
        enum Drinks {
            COKE("Coke"), PEPSI("Pepsi"), DRPEPPER("Dr.Pepper"), SPRITE("Sprite"), ICEDTEA("Iced Tea"), SWEETICEDTEA("Iced Tea(sweetened)"), WATER("Water"), LEMONADE("Lemonade");
            private String name;

            Drinks(String name) {
                this.name = name;
            }
        }
        System.out.println("Drink options");
        int index = 1;
        for (Drinks d : Drinks.values()) {
            System.out.println(index + ") " + d.name);
            index++;
        }
        System.out.print("Selection: ");
        int drinkSelection = inputScanner.nextInt();

        System.out.println("What size drink would you like?");
        System.out.println("1) Large");
        System.out.println("2) Medium");
        System.out.println("3) Small");
        System.out.print("Selection: ");
        int sizeOption = inputScanner.nextInt();

        Product product;
        Drinks drinkChoice = Drinks.values()[drinkSelection - 1];
        product = new Drink(drinkChoice.name, sizeOption);

        order.addProduct(product);
    }

    private static void handleAddChips() {
        enum Chips {
            SWEETPOTATO("Sweet potato"), LAYS("Classic lays"), HOTCHEETOS("Hot cheetos"), DORITOS("Doritos"), FUNYUNS("Funyuns");

            private String name;

            Chips(String name) {
                this.name = name;
            }
        }
        System.out.println("Chip selection");
        int index = 1;
        for (Chips c : Chips.values()) {
            System.out.println(index + ") " + c.name);
            index++;
        }
        System.out.print("Selection: ");
        int chipSelection = inputScanner.nextInt();

        Chips chipChoice = Chips.values()[chipSelection - 1];
        Product product = new BagOfChips(chipChoice.name);

        order.addProduct(product);


    }

    private static void handleCheckout() {

        System.out.println("Displaying order");
        System.out.println("Id: " + order.getOrderId() + " Order Name: " + order.getOrderName());
        for (Product p : order.getProducts()) {
            System.out.print(p + "\n");
        }
        System.out.println("Total price: " + order.getPrice());

        System.out.println("Enter 1) to confirm order");
        System.out.println("Enter 2) to cancel order");
        System.out.print("Selection:");
        int orderChoice = inputScanner.nextInt();
        boolean confirm = orderChoice == 1;
        if (confirm) {
            ReceiptFileManager.saveReceipt(order);
        } else if (!confirm) {
            order = null;
        }
        inputScanner.nextLine();

    }


}

