package com.europoint.poc.modules.poc.app.services.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class ServiceExceptionDetails implements Serializable {

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private final Date exceptionTime;
    public Collection<String> errors;

    public ServiceExceptionDetails(Collection<String> errors) {
        exceptionTime = new Date();
        this.errors = errors;
    }

    public ServiceExceptionDetails() {
        exceptionTime = new Date();
    }
}
