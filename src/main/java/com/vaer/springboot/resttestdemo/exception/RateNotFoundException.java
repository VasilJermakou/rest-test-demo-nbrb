package com.vaer.springboot.resttestdemo.exception;

/**
 * @created 25/01/2022 - 19:45 by VAER
 */
public class RateNotFoundException extends RuntimeException{

    /* constructors */
    public RateNotFoundException(String message) {
        super(message);
    }

    public RateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RateNotFoundException(Throwable cause) {
        super(cause);
    }
}
