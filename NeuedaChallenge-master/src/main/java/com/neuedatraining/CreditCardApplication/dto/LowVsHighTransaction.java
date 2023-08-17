package com.neuedatraining.CreditCardApplication.dto;

public class LowVsHighTransaction {
    private double amt;
    private double total_amt;


    public double getAmt() {
        return amt;
    }

    public void setAmt(double amount) {
        this.amt = amount;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }
}
