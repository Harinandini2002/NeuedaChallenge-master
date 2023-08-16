package com.neuedatraining.CreditCardApplication.dto;

public class CategoryTransaction {
    private String category;
    private double total_amt;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }
}
