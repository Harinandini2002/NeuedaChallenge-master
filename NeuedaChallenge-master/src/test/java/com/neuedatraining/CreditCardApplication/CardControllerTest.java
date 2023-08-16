package com.neuedatraining.CreditCardApplication;

import com.neuedatraining.CreditCardApplication.entity.CreditCardUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CardControllerTest {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void getAllUser(){

        ResponseEntity<List<CreditCardUser>> rEntity = template.exchange("/creditcard",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CreditCardUser>>() {
                });

        List<CreditCardUser> resp = rEntity.getBody();
        assertEquals(HttpStatus.OK,rEntity.getStatusCode());
        assertEquals(983,resp.size());



    }

    @Test
    public void insertUser() throws URISyntaxException {
        TestRestTemplate template1 = new TestRestTemplate();
        //  URI uri =  new URI("http://localhost:8080/creditcard");

        CreditCardUser user1 = new CreditCardUser(1, "Mary", "Kom", "F", "Boxer", null);

        ResponseEntity<CreditCardUser> userAdded = template1.postForEntity("/creditcard",user1, CreditCardUser.class);

        assertEquals("Boxer",userAdded.getBody().getJob());



    }

}
