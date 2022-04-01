package com.europoint.poc.web.controllers;

import com.europoint.poc.modules.poc.app.services.exceptions.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.server.ServerWebExchange;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.ThrowableProblem;
import org.zalando.problem.spring.webflux.advice.ProblemHandling;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@ControllerAdvice
public class ExceptionHandler implements ProblemHandling {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    Tracer tracer;

    @org.springframework.web.bind.annotation.ExceptionHandler
    ResponseEntity<ThrowableProblem> handleProblem(
            final ServiceException problem,
            final ServerWebExchange request) throws JsonProcessingException {
        return ResponseEntity.of(
                Optional.of(
                        Problem.builder()
                                .withType(URI.create("https://loggingapp.com/probs/service-error"))
                                .withTitle("ServiceException")
                                .withDetail(mapper.writeValueAsString(problem.getDetails()))
                                .withStatus(Status.BAD_REQUEST)
                                .with("message",problem.getMessage())
                                .with("traceId", Objects.requireNonNull(tracer.currentSpan()).context().traceId())
                                .build()
                ));
    }

}
