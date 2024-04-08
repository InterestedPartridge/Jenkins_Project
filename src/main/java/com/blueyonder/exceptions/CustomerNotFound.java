package com.blueyonder.exceptions;

public class CustomerNotFound extends Exception{
    public CustomerNotFound() {

    }

    public CustomerNotFound(String message) {
        super(message);
    }

    public CustomerNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotFound(Throwable cause) {
        super(cause);
    }

    public CustomerNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
