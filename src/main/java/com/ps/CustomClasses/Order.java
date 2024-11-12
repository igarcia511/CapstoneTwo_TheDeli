package com.ps.CustomClasses;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> products;
    private String orderName;
    private int orderId;

    public Order(String orderName, int orderId) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.products = new ArrayList<>();

    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public  void printOrder(){}
    public  void addProduct(Product product){
        products.add(product);
    }
    public List<Product> getProducts(){
        return products;
    }
    public  double getPrice(){

        double totalPrice = 0;
        for(Product p: products){
            totalPrice += p.getPrice();
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                '}';
    }
}
