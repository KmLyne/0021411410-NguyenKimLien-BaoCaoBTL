package com.kmlyne.PetCareServer.model;

import java.util.List;

public class OrderRequest {
    private String fullname;
    private String email;
    private int phonenumber;
    private String address;

    private int totalamount;
    private List<OrderDetailRequest> orderdetail;

    // Getters
    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public int getTotalamount() {
        return totalamount;
    }

    public List<OrderDetailRequest> getOrderdetail() {
        return orderdetail;
    }

    // Setters
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTotalamount(int totalamount) {
        this.totalamount = totalamount;
    }

    public void setOrderdetail(List<OrderDetailRequest> orderdetail) {
        this.orderdetail = orderdetail;
    }
}
