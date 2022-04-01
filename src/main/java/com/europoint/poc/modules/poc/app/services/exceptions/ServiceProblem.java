package com.europoint.poc.modules.poc.app.services.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class ServiceProblem extends AbstractThrowableProblem {
    private static final URI TYPE= URI.create("https://example.org/invalid-name");

    public ServiceProblem(String name) {
        super(
                TYPE,
                "Invalid name",
                Status.NOT_FOUND,
                String.format("Name '%s' is invalid", name));
    }
}
