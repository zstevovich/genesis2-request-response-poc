package com.europoint.poc.modules.poc.app.services.traits;

import com.europoint.poc.modules.poc.app.services.exceptions.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.ThrowableProblem;

import java.net.URI;
import java.util.Optional;

public interface ServiceExceptionTrait {

    ObjectMapper mapper = new ObjectMapper();

    @ExceptionHandler
    default ResponseEntity<ThrowableProblem> handleProblem(
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
                                .build()
                ));
    }
}
