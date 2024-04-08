package com.blueyonder.ui;

import com.blueyonder.model.Address;
import com.blueyonder.model.Customer;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        Address address = new Address();
        address.setAddressId(1);
        address.setStreet("Khao Gali");
        address.setCity("Ahmedabad");
        address.setState("Gujarat");
        address.setCountry("India");

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerName("BlueYonder");
        customer.setDateOfBirth(LocalDate.of(1990,10,15));
        customer.setAddress(address);
    }
}
