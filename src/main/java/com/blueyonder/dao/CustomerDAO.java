package com.blueyonder.dao;

import com.blueyonder.model.Customer;

import java.util.List;

public interface CustomerDAO {
    //Create
    public Customer addCustomer(Customer customer);
    //Retrieve
    public Customer getCustomerById(Integer customerId);
    //Update
    public Customer updateCustomer(Customer customer);
    //Delete
    public String deleteCustomerById(Integer customerId);
    // Retrieve all customer data
    public List<Customer> getAllCustomers();
}
