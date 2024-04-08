package util;

public interface QueryMapper {
    public static final String GET_CUSTOMER_BY_ID = "select * from customer where customerid = ?";
    public static final String GET_ALL_CUSTOMERS = "select * from customer";
    public static final String ADD_CUSTOMER = "insert into customer values(?, ?, ?);";
    public static final String UPDATE_CUSTOMER = "update customer set customername = ?, dateofbirth = ? where customerid = ?";
}
