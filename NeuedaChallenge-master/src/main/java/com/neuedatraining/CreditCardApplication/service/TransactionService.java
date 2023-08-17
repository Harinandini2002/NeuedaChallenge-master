package com.neuedatraining.CreditCardApplication.service;


import com.neuedatraining.CreditCardApplication.dto.*;
import com.neuedatraining.CreditCardApplication.entity.Transactions;
import com.neuedatraining.CreditCardApplication.exception.CardUserNotFoundException;
import com.neuedatraining.CreditCardApplication.repository.TransactionMongoTemplate;
import com.neuedatraining.CreditCardApplication.repository.Transactionrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private Transactionrepo repo;
    @Autowired
    private TransactionMongoTemplate temp;

    public long getTransCount(){
        return this.repo.count();
    }
    public List<Transactions> getUsers(){
        return repo.findAll();
    }
    public List<Transactions> findCardUsersByRegion(String city){
        return this.repo.findByCity(city);
    }
    public List<Transactions> findCardUsersByState(String state){
        return this.repo.findByState(state);
    }
    public List<Transactions> findCardUsersByCategory(String category){
        return this.repo.findByCategory(category);
    }
    public List<Transactions> findCardUsersByMerchant(String merchant){
        return this.repo.findByMerchant(merchant);
    }

    public List<Transactions> findCardUsersByName(String fName,String lName){
        return this.repo.findByName(fName,lName);
    }
    //findTransactionsWithAmountGreaterThan


    /*
    public List<Transactions> findTransactionsBetween(double minAmount,double maxAmount){
        return this.repo.findTransactionsWithAmountBetween(minAmount,maxAmount);
    }*/
    public List<Transactions> findCardUsersByCustomerId(int customer_id) throws CardUserNotFoundException{
        return this.repo.findByCustomerId(customer_id);
    }
    public List<Transactions> getTransactionsByCityAmountSort(String city, double amt){
        return repo.findAllTransactionsByCityAmountSort(city, amt);
    }
    public List<Transactions> getTransactionsByMerchantAmountSort(String merchant, double amt){
        return repo.findAllTransactionsByMerchantAmountSort(merchant, amt);
    }
    public List<Transactions> getTransactionsByCategoryAmountSort(String category, double amt){
        return repo.findAllTransactionsByCategoryAmountSort(category, amt);
    }
    public List<Transactions> getTransactionsByAmountLimitSort(double minAmount,double maxAmount){
        return repo.findAllTransactionsByAmountLimitSort(minAmount,maxAmount);
    }
    public List<CityTransaction> getAmountByCity(){
        return temp.getAmountBasedOnCity();
    }
    public List<CategoryTransaction> getAmountByCategory(){
        return temp.getAmountBasedOnCategory();
    }
    public List<JobTransaction> getAmountByJob(){
        return temp.getAmountBasedOnJob();
    }
    public List<MerchantTransaction> getAmountByMerchant(){
        return temp.getAmountBasedOnMerchant();
    }
    public List<StateTransaction> getAmountByState(){
        return temp.getAmountBasedOnState();
    }
    public List<LowVsHighTransaction> getAmountByThreshold(){
        return temp.getAmountLowVsHigh();
    }


}
