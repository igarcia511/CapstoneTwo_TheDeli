package com.ps;

import com.ps.CustomClasses.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptFileManager {

    public static void saveReceipt(Order order){
        String folderName = "Receipt";
        File directory = new File("Receipt");
        if(!directory.exists()){
            directory.mkdir();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String timeOfOrder = dateFormat.format(new Date());

        String fileName = folderName + File.separator + "Id_" +order.getOrderId() + "_Order Name_" + order.getOrderName() + ".txt";
        File receiptFile = new File(fileName);
          StringBuilder sandwichOrders = new StringBuilder();
          StringBuilder drinkOrders = new StringBuilder();
          StringBuilder chipOrders = new StringBuilder();
        for(Product p : order.getProducts()){

            if(p instanceof Sandwich s){
                 String sandwichOrder = String.format("Sandwich: %s, %s, %s | Toppings: %s | Extras: %s | Sauce: %s | Side: %s",
                        s.getBreadType(),
                        s.getSize(),
                        s.getIsToasted(),
                         s.getToppingsAsString(),
                         s.getExtrasAsString(),
                         s.getSauceString(),
                         s.getSidesString());
                   sandwichOrders.append(sandwichOrder).append("\n");
            }

            if(p instanceof Drink d){
                String drinkOrder = String.format("Drink: %s, Size: %s",
                        d.getName(),
                        d.getStringSize());
                   drinkOrders.append(drinkOrder).append("\n");
            }

            if(p instanceof BagOfChips c){
               String chipOrder = String.format("Chips: %s", c.getName());
               chipOrders.append(chipOrder).append("\n");
            }
          }

            String thankYou = "=========================================================\n" +
                    "___________.__           ________         .__  .__ \n" +
                    "\\__    ___/|  |__   ____ \\______ \\   ____ |  | |__|\n" +
                    "  |    |   |  |  \\_/ __ \\ |    |  \\_/ __ \\|  | |  |\n" +
                    "  |    |   |   Y  \\  ___/ |    `   \\  ___/|  |_|  |\n" +
                    "  |____|   |___|  /\\___  >_______  /\\___  >____/__|\n" +
                    "                \\/     \\/        \\/     \\/                 \n" +
                    "=========================================================\n";



        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(receiptFile));

            bufferedWriter.write("=========================================================\n");
            bufferedWriter.write("Order Id: "+ order.getOrderId() + " Order Name: " + order.getOrderName() + "\n");
            bufferedWriter.write("Time of order: " + timeOfOrder + "\n");
            bufferedWriter.write("=========================================================\n");
            bufferedWriter.write("Items: \n");
            if(!sandwichOrders.isEmpty()){
                bufferedWriter.write("\n" + sandwichOrders);
            }
            if(!drinkOrders.isEmpty()){
                bufferedWriter.write("\n" + drinkOrders);
            }
            if(!chipOrders.isEmpty()){
                bufferedWriter.write("\n" + chipOrders);
            }
            bufferedWriter.write("---------------------------------------------------------\n");
            bufferedWriter.write(String.format("Total Price: %.2f", order.getPrice()) +"\n");
            bufferedWriter.write("=========================================================\n");
            bufferedWriter.write("Thank you for your order!\n");
            bufferedWriter.write(thankYou);


            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
