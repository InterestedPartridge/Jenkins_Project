package com.blueyonder.dao;

import com.blueyonder.model.Address;
import util.DBConnectionUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AddressDAOImpl implements AddressDAO {
    @Override
    public Address addAddress(Address address) {
        Connection conn = DBConnectionUtil.getDBConnection();
        try {
            CallableStatement cstmt = conn.prepareCall("{call insertAddress(?,?,?,?,?,?)}");
            cstmt.setInt(1, address.getAddressId());
            cstmt.setString(2, address.getStreet());
            cstmt.setString(3, address.getCity());
            cstmt.setString(4, address.getState());
            cstmt.setString(5, address.getCountry());
            cstmt.setString(6, "False");
            int rows = cstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
