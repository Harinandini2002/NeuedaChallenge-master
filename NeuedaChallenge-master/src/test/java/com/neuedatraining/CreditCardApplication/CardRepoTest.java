package com.neuedatraining.CreditCardApplication;

import com.neuedatraining.CreditCardApplication.entity.CreditCardUser;
import com.neuedatraining.CreditCardApplication.repository.CreditCardUserRepo;
import org.assertj.core.api.AbstractFileAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class CardRepoTest {

    @Autowired
    private CreditCardUserRepo repo;

    @Test
    public void findUserByName(){
        repo.save(new CreditCardUser(4, "John","Matthew","M","Cook",null));
        CreditCardUser userFound = repo.findByName("John","Matthew");

        assertEquals("Cook",userFound.getJob());
    }

    @Test
    public void existsByCustomerId(){

        assertEquals(true,repo.existsByCustomerId(6));

    }


}
