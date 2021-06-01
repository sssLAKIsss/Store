package ru.tfs.coreService.exceptions;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }

    private CustomException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
