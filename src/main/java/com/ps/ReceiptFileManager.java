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
          String sandwichOrder = null;
//          String toppings;
//          String extraToppings;
          String drinkOrder = null;
          String chipOrder;
        for(Product p : order.getProducts()){
            if(p instanceof Sandwich s){
                 sandwichOrder = String.format("Sandwich: %s, %s, %s | Toppings: %s | Extras: %s",
                        s.getBreadType(),
                        s.getSize(),
                        s.getIsToasted(),
                         s.getToppingsAsString(),
                         s.getExtrasAsString());
            }

            if(p instanceof Drink d){
                drinkOrder = String.format("Drink(s): %s, Size: %s",
                        d.getName(),
                        d.getStringSize());

            }
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(receiptFile));
            bufferedWriter.write("Order Id: "+ order.getOrderId() + " Order Name: " + order.getOrderName() + " Time of order: " + timeOfOrder);
            bufferedWriter.write("\n---------------------------------------------------");
            if(!sandwichOrder.isEmpty()){
                bufferedWriter.write("\n" + sandwichOrder);
            }
            if(!drinkOrder.isEmpty()){
                bufferedWriter.write("\n" + drinkOrder);
            }

            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
