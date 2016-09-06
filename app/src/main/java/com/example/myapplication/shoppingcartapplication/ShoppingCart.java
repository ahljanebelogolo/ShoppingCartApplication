package com.example.myapplication.shoppingcartapplication;

/**
 * Created by Jeremy on 9/3/2016.
 */
public class ShoppingCart {
    //itemName|||quantity|||price

    private String itemName;
    private int itemQuantity;
    private double itemPrice;
    private double itemTotalPrice;

    public ShoppingCart() {

    }

    public ShoppingCart(String itemName, int itemQuantity, double itemPrice, double itemTotalPrice) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.itemTotalPrice = itemTotalPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(double itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }
}
