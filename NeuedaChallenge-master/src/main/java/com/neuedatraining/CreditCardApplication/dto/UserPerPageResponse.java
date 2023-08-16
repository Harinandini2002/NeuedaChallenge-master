package com.neuedatraining.CreditCardApplication.dto;

import com.neuedatraining.CreditCardApplication.entity.CreditCardUser;

import java.util.List;

public class UserPerPageResponse {

    int totalPages;
    long totalElements;
    int noOfelements ;
    int pageSize ;
    int pageNo;
    List<CreditCardUser> users;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getNoofelements() {
        return noOfelements;
    }

    public void setNoofelements(int noOfelements) {
        this.noOfelements = noOfelements;
    }

    public int getPagesize() {
        return pageSize;
    }

    public void setPagesize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<CreditCardUser> getUsers() {
        return users;
    }

    public void setUsers(List<CreditCardUser> users) {
        this.users = users;
    }
}