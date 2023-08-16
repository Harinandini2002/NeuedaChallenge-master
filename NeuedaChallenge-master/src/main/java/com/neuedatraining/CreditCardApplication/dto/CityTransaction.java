package com.neuedatraining.CreditCardApplication.dto;

public class CityTransaction {
    private String city;
    private double total_amt;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }
}
