package com.neuedatraining.CreditCardApplication.repository;

import com.neuedatraining.CreditCardApplication.entity.CreditCardUser;
import com.neuedatraining.CreditCardApplication.entity.Transactions;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface Transactionrepo extends MongoRepository<Transactions, ObjectId> {
    @Query("{ 'city' : ?0 }")
    public List<Transactions> findByCity(String city);

    @Query("{ 'state' : ?0 }")
    public List<Transactions> findByState(String state);
    @Query("{ 'category' : ?0 }")
    public List<Transactions> findByCategory(String category);
    @Query("{ 'merchant' : ?0 }")
    public List<Transactions> findByMerchant(String merchant);


    @Query("{ 'first' : ?0, 'last': ?1 }")
    public List<Transactions> findByName(String fName,String lName);

    @Query("{ 'customer_id' : ?0 }")
    public List<Transactions> findByCustomerId(int customer_id);


    /*
    @Query("{ 'amt' : { $gte : ?0, $lte : ?1 } }")
    List<Transactions> findTransactionsWithAmountBetween(double minAmount, double maxAmount);
    */

         @Aggregation(pipeline = {
                 "{'$match':{'city':?0, 'amt': {$gt: ?1} }}",
                 "{'$sample':{size:10}}",
                 "{'$sort':{'Quantity':-1}}"
         })

    List<Transactions> findAllTransactionsByCityAmountSort(String city,double amt);
        @Aggregation(pipeline = {
                "{'$match':{'merchant':?0, 'amt': {$gt: ?1} }}",
                "{'$sample':{size:10}}",
                "{'$sort':{'Quantity':-1}}"
        })

    List<Transactions> findAllTransactionsByMerchantAmountSort(String merchant,double amt);
        @Aggregation(pipeline = {
                "{'$match':{'category':?0, 'amt': {$gt: ?1} }}",
                "{'$sample':{size:10}}",
                "{'$sort':{'Quantity':-1}}"
        })

    List<Transactions> findAllTransactionsByCategoryAmountSort(String Category,double amt);

    @Aggregation(pipeline = {
            "{'$match':{ 'amt' : { $gt : ?0}, 'amt':{$lt : ?1 }}",
            "{'$sample':{size:10}}",
            "{'$sort':{'Quantity':-1}}"
    })

    List<Transactions> findAllTransactionsByAmountLimitSort(double minAmount,double maxAmount);




}
