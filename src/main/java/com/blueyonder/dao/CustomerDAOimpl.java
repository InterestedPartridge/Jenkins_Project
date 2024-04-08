package com.blueyonder.dao;

import com.blueyonder.model.Customer;
import util.CustomerResultSetHelper;
import util.DBConnectionUtil;
import util.QueryMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOimpl implements CustomerDAO {
    @Override
    public Customer addCustomer(Customer customer) {
        // TO DO logic to perform db operations
        DBConnectionUtil connection = new DBConnectionUtil();
        try {
            Connection conn = connection.getDBConnection();
            PreparedStatement pstmt = conn.prepareStatement(QueryMapper.ADD_CUSTOMER);
            pstmt.setInt(1, customer.getCustomerId());
            pstmt.setString(2, customer.getCustomerName());
            pstmt.setDate(3, Date.valueOf(customer.getDateOfBirth()));
            int isQueryExecuted = pstmt.executeUpdate();
            if (isQueryExecuted > 0) {
                System.out.println("customer added successfully");
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
//        String URL = "jdbc:postgresql://localhost:5432/bydb";
        DBConnectionUtil connection = new DBConnectionUtil();
        Customer customer = new Customer();
        try {
            //Getting connection object
            Connection conn = connection.getDBConnection();
//            Connection conn = DriverManager.getConnection(URL, "postgres", "postgres");
            // statement
//            Statement stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement(QueryMapper.GET_CUSTOMER_BY_ID);
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            // execute statement
//            ResultSet rs = stmt.executeQuery("select * from customer where customerid = 1;");

            // handle result
            while (rs.next()) {
//                customer.setCustomerId(rs.getInt(1));
//                customer.setCustomerName(rs.getString(2));
//                customer.setDateOfBirth(rs.getDate(3).toLocalDate());
                CustomerResultSetHelper.resultSetToCustomer(customer, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return customer;
    }

//    public Customer updateCustomer(Customer customer) {
//        try {
//            Customer cust = getCustomerById(customer.getCustomerId());
//
//            if (cust.getCustomerId() == null) {
//                System.out.println("Customer not found.");
//                return null; // or throw an exception if you want to indicate the failure more explicitly
//            }
//
//            try (Connection conn = DBConnectionUtil.getDBConnection();
//                 PreparedStatement pstmt = conn.prepareStatement(QueryMapper.UPDATE_CUSTOMER)) {
//
//                pstmt.setString(1, customer.getCustomerName());
//                pstmt.setDate(2, Date.valueOf(customer.getDateOfBirth()));
//                pstmt.setInt(3, customer.getCustomerId());
//
//                int rowsUpdated = pstmt.executeUpdate();
//
//                if (rowsUpdated > 0) {
//                    System.out.println("Customer updated successfully");
//                } else {
//                    System.out.println("Failed to update customer. No rows were affected.");
//                }
//            }
//        } catch (SQLException e) {
//            // Log the exception or handle it appropriately
//            System.err.println("Error updating customer: " + e.getMessage());
//            throw new RuntimeException("Error updating customer", e);
//        }
//
//        return customer;
//    }

    @Override
    public Customer updateCustomer(Customer customer) {
        try {
            Customer cust = getCustomerById(customer.getCustomerId());

            if (cust.getCustomerId() == null) {
                System.out.println("Customer not found.");
                return null; // or throw an exception if you want to indicate the failure more explicitly
            }

            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                conn = DBConnectionUtil.getDBConnection();
                pstmt = conn.prepareStatement(QueryMapper.UPDATE_CUSTOMER);
                pstmt.setString(1, customer.getCustomerName());
                pstmt.setDate(2, Date.valueOf(customer.getDateOfBirth()));
                pstmt.setInt(3, customer.getCustomerId());

                int rowsUpdated = pstmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Customer updated successfully");
                } else {
                    System.out.println("Failed to update customer. No rows were affected.");
                }
            } finally {
                // Close resources in the finally block
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace(); // Log or handle the exception appropriately
                }
            }
        } catch (SQLException e) {
            // Log the exception or handle it appropriately
            System.err.println("Error updating customer: " + e.getMessage());
            throw new RuntimeException("Error updating customer", e);
        }

        return customer;
    }


    @Override
    public String deleteCustomerById(Integer customerId) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
//        String URL = "jdbc:postgresql://localhost:5432/bydb";
        List<Customer> customerList = new ArrayList<>();
        DBConnectionUtil connection = new DBConnectionUtil();
        try {
            //Getting connection object
//            Connection conn = DriverManager.getConnection(URL, "postgres", "postgres");
            Connection conn = connection.getDBConnection();
            // statement
            Statement stmt = conn.createStatement();
            // execute statement
            ResultSet rs = stmt.executeQuery(QueryMapper.GET_ALL_CUSTOMERS);
            // handle result
            while (rs.next()) {
                Customer customer = new Customer();
                CustomerResultSetHelper.resultSetToCustomer(customer, rs);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }
}
