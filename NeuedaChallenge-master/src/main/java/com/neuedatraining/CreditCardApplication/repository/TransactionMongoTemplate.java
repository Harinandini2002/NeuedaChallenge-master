package com.neuedatraining.CreditCardApplication.repository;

import com.neuedatraining.CreditCardApplication.dto.*;
import com.neuedatraining.CreditCardApplication.entity.Transactions;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class TransactionMongoTemplate implements TemplateRepo {

    @Autowired
    private MongoTemplate mongoTemplate;



    @Override
    public List<CityTransaction> getAmountBasedOnCity() {
        // MongoTemplate pipeline
        GroupOperation groupByCitySumAmount = group("city").sum("amt").as("total_amt");
        MatchOperation allCities = match(new Criteria("city").exists(true));
        ProjectionOperation includes = project("total_amt").and("city").previousOperation();
        SortOperation sortByAmountDesc = sort(Sort.by(Sort.Direction.DESC, "total_amt"));
        Aggregation aggregation = newAggregation(allCities, groupByCitySumAmount, sortByAmountDesc, includes);
        AggregationResults<CityTransaction> groupResults = mongoTemplate.aggregate(aggregation, "transactions", CityTransaction.class);
        List<CityTransaction> result = groupResults.getMappedResults();
        return result;
    }


    @Override
    public List<CategoryTransaction> getAmountBasedOnCategory() {
        // MongoTemplate pipeline
        GroupOperation groupByCategorySumAmount = group("category").sum("amt").as("total_amt");
        MatchOperation allCategories = match(new Criteria("category").exists(true));
        ProjectionOperation includes = project("total_amt").and("category").previousOperation();
        SortOperation sortByAmountDesc = sort(Sort.by(Sort.Direction.DESC, "total_amt"));
        Aggregation aggregation = newAggregation(allCategories, groupByCategorySumAmount, sortByAmountDesc, includes);
        AggregationResults<CategoryTransaction> groupResults = mongoTemplate.aggregate(aggregation, "transactions", CategoryTransaction.class);
        List<CategoryTransaction> result = groupResults.getMappedResults();
        return result;
    }

    @Override
    public List<JobTransaction> getAmountBasedOnJob() {
        // MongoTemplate pipeline
        GroupOperation groupByJobSumAmount = group("job").sum("amt").as("total_amt");
        MatchOperation allJobs = match(new Criteria("job").exists(true));
        ProjectionOperation includes = project("total_amt").and("job").previousOperation();
        SortOperation sortByAmountDesc = sort(Sort.by(Sort.Direction.DESC, "total_amt"));
        Aggregation aggregation = newAggregation(allJobs, groupByJobSumAmount, sortByAmountDesc, includes);
        AggregationResults<JobTransaction> groupResults = mongoTemplate.aggregate(aggregation, "transactions", JobTransaction.class);
        List<JobTransaction> result = groupResults.getMappedResults();
        return result;
    }


    @Override
    public List<MerchantTransaction> getAmountBasedOnMerchant() {
        // MongoTemplate pipeline
        GroupOperation groupByMerchantSumAmount = group("merchant").sum("amt").as("total_amt");
        MatchOperation allMerchant = match(new Criteria("merchant").exists(true));
        ProjectionOperation includes = project("total_amt").and("merchant").previousOperation();
        SortOperation sortByAmountDesc = sort(Sort.by(Sort.Direction.DESC, "total_amt"));
        Aggregation aggregation = newAggregation(allMerchant, groupByMerchantSumAmount, sortByAmountDesc, includes);
        AggregationResults<MerchantTransaction> groupResults = mongoTemplate.aggregate(aggregation, "transactions", MerchantTransaction.class);
        List<MerchantTransaction> result = groupResults.getMappedResults();
        return result;
    }


    @Override
    public List<StateTransaction> getAmountBasedOnState() {
        // MongoTemplate pipeline
        GroupOperation groupByStateSumAmount = group("state").sum("amt").as("total_amt");
        MatchOperation allStates = match(new Criteria("state").exists(true));
        ProjectionOperation includes = project("total_amt").and("state").previousOperation();
        SortOperation sortByAmountDesc = sort(Sort.by(Sort.Direction.DESC, "total_amt"));
        Aggregation aggregation = newAggregation(allStates, groupByStateSumAmount, sortByAmountDesc, includes);
        AggregationResults<StateTransaction> groupResults = mongoTemplate.aggregate(aggregation, "transactions", StateTransaction.class);
        List<StateTransaction> result = groupResults.getMappedResults();
        return result;
    }
}
