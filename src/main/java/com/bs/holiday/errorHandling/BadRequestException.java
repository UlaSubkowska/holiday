package com.bs.holiday.errorHandling;

public class BadRequestException extends RuntimeException {
        public BadRequestException(String exception) {
            super(exception);
        }
}
