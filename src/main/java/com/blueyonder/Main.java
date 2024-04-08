package com.blueyonder;

import com.blueyonder.dao.CustomerDAO;
import com.blueyonder.dao.CustomerDAOimpl;
import com.blueyonder.model.Customer;
import com.blueyonder.service.CustomerService;
import com.blueyonder.service.CustomerServiceimpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerService cdi = new CustomerServiceimpl();
//        cdi.getAllCustomers();
        List<Customer> listofCustomer = cdi.getAllCustomers();
        System.out.println(listofCustomer);
        for (Customer e : listofCustomer) {
            System.out.println(e.getCustomerName());
        }
        System.out.println(cdi.getCustomerById(1).getCustomerName());
//        cdi.addCustomer(customer);
        Customer customer = new Customer();
        customer.setCustomerId(299);
        customer.setCustomerName("rohit");
        customer.setDateOfBirth(LocalDate.of(2003,1,15));
        Customer cc = cdi.updateCustomer(customer);
    }
}