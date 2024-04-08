package com.blueyonder.exceptions;

public class AddressNotFoundExceptions extends Exception{
    public AddressNotFoundExceptions() {

    }

    public AddressNotFoundExceptions(String message) {
        super(message);
    }

    public AddressNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotFoundExceptions(Throwable cause) {
        super(cause);
    }

    public AddressNotFoundExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
