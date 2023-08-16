package com.neuedatraining.CreditCardApplication.controller;

import com.neuedatraining.CreditCardApplication.entity.Transactions;
import com.neuedatraining.CreditCardApplication.exception.CardUserNotFoundException;
import com.neuedatraining.CreditCardApplication.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService service;
    @GetMapping
    public List<Transactions> getAllUser() {
        return  this.service.getUsers();
    }
    @GetMapping("/mapCity")
    public List<Transactions> getUsersByCity(@RequestParam("city") String city) {
        if(city == null)
            return this.service.getUsers();
        return  this.service.findCardUsersByRegion(city);
    }
    @GetMapping("/mapState")
    public List<Transactions> getUsersByState(@RequestParam("state") String state) {
        if(state == null)
            return this.service.getUsers();
        return  this.service.findCardUsersByState(state);
    }

    @GetMapping("/mapCategory")
    public List<Transactions> getUsersByCategory(@RequestParam("category") String category) {
        if(category == null)
            return this.service.getUsers();
        return  this.service.findCardUsersByCategory(category);
    }
    @GetMapping("/mapMerchant")
    public List<Transactions> getUsersByMerchant(@RequestParam("merchant") String merchant) {
        if(merchant == null)
            return this.service.getUsers();
        return  this.service.findCardUsersByMerchant(merchant);
    }



/*
    @GetMapping("/mapBAmount")
    public List<Transactions> getTransactionsInBetween(@RequestParam("minAmount") double minAmount,@RequestParam("maxAmount") double maxAmount) {
        return  this.service.findTransactionsBetween(minAmount,maxAmount);
    }

 */
    @GetMapping("/mapCityAmount")
    public List<Transactions> getTransactionsByCity(@RequestParam String city,
                                       @RequestParam double amt)
    {
        return service.getTransactionsByCityAmountSort(city, amt);
    }
    @GetMapping("/mapMerchantAmount")
    public List<Transactions> getTransactionsByMerchant(@RequestParam String merchant,
                                                    @RequestParam double amt)
    {
        return service.getTransactionsByMerchantAmountSort(merchant, amt);
    }
    @GetMapping("/mapCategoryAmount")
    public List<Transactions> getTransactionsByCategory(@RequestParam String category,
                                                        @RequestParam double amt)
    {
        return service.getTransactionsByCategoryAmountSort(category, amt);
    }
    @GetMapping("/mapAmountLimit")
    public List<Transactions> getTransactionsByAmount(@RequestParam("minAmount") double minAmount,@RequestParam("maxAmount") double maxAmount)
    {
        return service.getTransactionsByAmountLimitSort(minAmount,maxAmount);
    }
    @GetMapping("/mapName")
    public ResponseEntity<List<Transactions>> getUsersByFName(@RequestParam("first") String first, @RequestParam("last") String last) {
        List<Transactions> user = service.findCardUsersByName(first, last);
        if (user != null) {
            return ResponseEntity.ok(user); // Return the user with 200 status code
        } else {
            return ResponseEntity.notFound().build(); // Return 404 status code
        }
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<List<Transactions>> getUserById(@PathVariable int customer_id) {
        try {
            List<Transactions> user = service.findCardUsersByCustomerId(customer_id);
            return ResponseEntity.ok(user);
        } catch (CardUserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
