package com.europoint.poc.modules.poc.app.services.exceptions;

public class ServiceException extends RuntimeException {
    @lombok.Getter
    private final String message;
    @lombok.Getter
    public String threadId;
    @lombok.Getter
    private final ServiceExceptionDetails details;

    public ServiceException(String message) {
        super(message);
        this.message = message;
        this.details = new ServiceExceptionDetails();
        this.threadId=Thread.currentThread().getName();
    }

    public ServiceException(String message,ServiceExceptionDetails details) {
        super(message);
        this.message = message;
        this.details = details;
        this.threadId=Thread.currentThread().getName();
    }
}
