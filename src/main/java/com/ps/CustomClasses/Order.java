package com.ps.CustomClasses;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> products;

    public Order(){
        products = new ArrayList<>();
    }
    public  void printOrder(){}
    public  void addProduct(Product product){
        products.add(product);
    }
    public  double getPrice(){return 0;}
    public List<Product> getProducts(){
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                '}';
    }
}
