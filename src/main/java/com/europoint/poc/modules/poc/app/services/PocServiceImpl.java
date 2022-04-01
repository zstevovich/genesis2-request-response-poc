package com.europoint.poc.modules.poc.app.services;

import com.europoint.poc.modules.poc.api.appservicecontracts.dtos.PocDto;
import com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces.PocService;
import com.europoint.poc.modules.poc.app.services.exceptions.ServiceException;
import com.europoint.poc.modules.poc.app.services.exceptions.ServiceExceptionDetails;
import com.europoint.poc.modules.poc.app.services.exceptions.ServiceProblem;
import com.europoint.poc.modules.poc.domain.entities.PocEntity;
import im.aop.loggers.advice.around.LogAround;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Service
public class PocServiceImpl implements PocService {

    @LogAround
    @Override
    public Mono<PocDto> getPocData(String name) throws Exception {
        String one = "Perino ime je ruzno";
        String second = "Perino ime je kratko";
        Collection<String> errors = new ArrayList<>();
        errors.add(one);
        errors.add(second);
        if (Objects.equals(name, "Pera")) {
            ServiceExceptionDetails details = new ServiceExceptionDetails(errors);
            throw new ServiceException("Pera is Invalid name",details);
        }
        if (Objects.equals(name, "Zika")) {
            throw new ServiceProblem("Zika Is Invalid name");
        }
        if (Objects.equals(name, "Steva")) {
            throw new ServiceException("Steva Is Invalid name");
        }
        if (Objects.equals(name, "Obican")) {
            throw new Exception("Obican Is Invalid name");
        }
        PocEntity poc = new PocEntity(name,"Dobracina");
        return Mono.just(new PocDto(poc.getName(), poc.getAddress()));
    }
}
