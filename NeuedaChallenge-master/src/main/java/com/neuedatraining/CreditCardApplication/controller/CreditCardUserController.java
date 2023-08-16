package com.neuedatraining.CreditCardApplication.controller;

import com.neuedatraining.CreditCardApplication.dto.UserPerPageResponse;
import com.neuedatraining.CreditCardApplication.entity.CreditCardUser;
import com.neuedatraining.CreditCardApplication.entity.Transactions;
import com.neuedatraining.CreditCardApplication.exception.CardUserAlreadyFoundException;
import com.neuedatraining.CreditCardApplication.exception.CardUserNotFoundException;
import com.neuedatraining.CreditCardApplication.service.CardUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/CreditCardApp")
public class CreditCardUserController {
    @Autowired
    private CardUserService service;
    @GetMapping
    public List<CreditCardUser> getAllUser() {
        return  this.service.getUsers();
  }
    public ResponseEntity<List<CreditCardUser>> getUserById(@PathVariable int customer_id) {
        try {
            List<CreditCardUser> users = service.findCardUserByCustomerId(customer_id);
            return ResponseEntity.ok(users);
        } catch (CardUserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/mapName")
    public ResponseEntity<CreditCardUser> getUsersByFName(@RequestParam("first") String first, @RequestParam("last") String last) {
        CreditCardUser user = service.findCardUserByName(first, last);
        if (user != null) {
            return ResponseEntity.ok(user); // Return the user with 200 status code
        } else {
            return ResponseEntity.notFound().build(); // Return 404 status code
        }
    }
    @GetMapping("/mapGender")
    public List<CreditCardUser> getUsersByGender(@RequestParam("gender") String gender) {
        if(gender == null)
            return this.service.getUsers();
        return  this.service.findCardUserByGender(gender);
    }
    @GetMapping("/mapJob")
    public List<CreditCardUser> getUsersByJob(@RequestParam("job") String job) {
        if(job == null)
            return this.service.getUsers();
        return  this.service.findCardUserByJob(job);
    }

    @PostMapping
    public ResponseEntity<String> insertUser(@RequestBody CreditCardUser creditCardUser) {
        try {
            service.insertUser(creditCardUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("User inserted successfully");
        } catch (CardUserAlreadyFoundException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this customer ID already exists");
        }
    }
    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody CreditCardUser creditCardUser) {
        try {
            service.updateUser(creditCardUser);
            return ResponseEntity.ok("User updated successfully");
        } catch (CardUserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with this customer ID not found");
        }
    }
    @DeleteMapping("/{customer_id}")
    public ResponseEntity<String> deleteUser(@PathVariable int customer_id) {
        try {
            service.deleteUser(customer_id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (CardUserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with this customer ID not found");
        }
    }
    @GetMapping("/pages")
    public UserPerPageResponse getEmployeesByPage(@RequestParam(required = false, defaultValue = "49") int pageno,
                                                  @RequestParam(required = false, defaultValue = "20") int size)
    {
        return this.service.getEmployeesByPagination(pageno, size);
    }

}