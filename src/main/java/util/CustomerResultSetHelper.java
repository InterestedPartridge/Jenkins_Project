package util;

import com.blueyonder.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerResultSetHelper {
    public static Customer resultSetToCustomer(Customer cust, ResultSet rs) {
        try {
            cust.setCustomerId(rs.getInt(1));
            cust.setCustomerName(rs.getString("customername"));
            cust.setDateOfBirth(rs.getDate(3).toLocalDate());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return cust;
    }
}
