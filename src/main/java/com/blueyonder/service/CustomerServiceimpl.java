package com.blueyonder.service;

import com.blueyonder.dao.CustomerDAO;
import com.blueyonder.dao.CustomerDAOimpl;
import com.blueyonder.model.Customer;

import java.util.List;

public class CustomerServiceimpl implements CustomerService{
    private CustomerDAO customerDAO = new CustomerDAOimpl();
    @Override
    public Customer addCustomer(Customer customer) {
        return customerDAO.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return customerDAO.getCustomerById(customerId);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    @Override
    public String deleteCustomerById(Integer customerId) {
        return customerDAO.deleteCustomerById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }
}
