package com.europoint.poc.modules.poc.app.services.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;
import java.util.Collection;

public class ServiceProblems  extends AbstractThrowableProblem {
    private static final URI TYPE= URI.create("https://example.org/invalid-name");
    private Collection<String> errors;
    public ServiceProblems(Collection<String> errors){
        super(
                TYPE,
                "Invalid values",
                Status.NOT_FOUND,
                errors.toString()
        );
    }
}
