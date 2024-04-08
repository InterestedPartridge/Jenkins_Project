package com.blueyonder.service;

import com.blueyonder.model.Customer;

import java.util.List;

public interface CustomerService {
    //Create
    public Customer addCustomer(Customer customer);
    //Retrive
    public Customer getCustomerById(Integer customerId);
    //Update
    public Customer updateCustomer(Customer customer);
    //Delete
    public String deleteCustomerById(Integer customerId);
    //Retrieve all
    public List<Customer> getAllCustomers();
}
