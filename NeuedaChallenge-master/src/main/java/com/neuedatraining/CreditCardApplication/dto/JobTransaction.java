package com.neuedatraining.CreditCardApplication.dto;

public class JobTransaction {
    private String job;
    private double total_amt;


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(double total_amt) {
        this.total_amt = total_amt;
    }
}