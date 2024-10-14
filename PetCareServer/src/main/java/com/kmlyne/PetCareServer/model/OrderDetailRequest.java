package com.kmlyne.PetCareServer.model;

public class OrderDetailRequest {
    private int productid;
    private int quantity;
    private int price;

    // Getters
    public int getProductid() {
        return productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    // Setters
    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
