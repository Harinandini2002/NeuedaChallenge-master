package com.neuedatraining.CreditCardApplication.service;

import com.neuedatraining.CreditCardApplication.dto.UserPerPageResponse;
import com.neuedatraining.CreditCardApplication.entity.CreditCardUser;
import com.neuedatraining.CreditCardApplication.entity.Transactions;
import com.neuedatraining.CreditCardApplication.exception.CardUserAlreadyFoundException;
import com.neuedatraining.CreditCardApplication.exception.CardUserNotFoundException;
import com.neuedatraining.CreditCardApplication.repository.CreditCardUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;



import java.util.List;

@Service
public class CardUserService {
    @Autowired
    private CreditCardUserRepo repo;

    public long countUser() {
        return this.repo.count();
    }

    public List<CreditCardUser> getUsers() {
        return repo.findAll();
    }

    public List<CreditCardUser> findCardUserByCustomerId(int customer_id) throws CardUserNotFoundException {
        return repo.findByCustomerId(customer_id);
    }
    public CreditCardUser findCardUserByName(String fName,String lName){
        return repo.findByName(fName,lName);
    }

    public List<CreditCardUser> findCardUserByGender(String gender) {
        return repo.findByGender(gender);
    }
    public List<CreditCardUser> findCardUserByJob(String job){
        return repo.findByJob(job);}

    public void insertUser(CreditCardUser user) throws CardUserAlreadyFoundException {
        if(repo.existsByCustomerId(user.getCustomerId()))
            throw new CardUserAlreadyFoundException("Card user with "+user.getCustomerId()+" already exists");
        repo.save(user);
    }

    public void updateUser( CreditCardUser userToUpdate) throws CardUserNotFoundException {
        if(! repo.existsByCustomerId(userToUpdate.getCustomerId()))
            throw new CardUserNotFoundException("User with "+userToUpdate.getCustomerId()+" does not exist");
        repo.save(userToUpdate);
    }
    public void deleteUser(int customer_id) throws CardUserNotFoundException {
        if (repo.existsByCustomerId(customer_id)) {
            repo.deleteByCustomerId(customer_id);
        } else {
            throw new CardUserNotFoundException("User with " + customer_id + " does not exist");
        }
    }
    //pagenation
    public UserPerPageResponse getEmployeesByPagination(int pageNo, int size) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo, size);
        Page<CreditCardUser> page = repo.findAll(pageable);
        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        int noOfelements = page.getNumberOfElements();
        int pageSize = page.getSize();
        UserPerPageResponse response = new UserPerPageResponse();
        response.setUsers(page.getContent());
        response.setNoofelements(noOfelements);
        response.setPagesize(pageSize);
        response.setTotalElements(totalElements);
        response.setTotalPages(totalPages);
        return response;
    }


}
