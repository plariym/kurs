package com.example.shopapp.repository;


import com.example.shopapp.model.Customer;

public class CustomerDao extends BaseDao<Customer> {
    public CustomerDao() {
        super(Customer.class);
    }
}
