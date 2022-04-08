package com.europoint.poc.modules.poc.app.services;

import com.europoint.poc.modules.poc.api.appservicecontracts.dtos.PocDto;
import com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces.PocReactiveService;
import com.europoint.poc.modules.poc.app.services.exceptions.ServiceException;
import com.europoint.poc.modules.poc.app.services.exceptions.ServiceExceptionDetails;
import com.europoint.poc.modules.poc.app.services.exceptions.ServiceProblem;
import com.europoint.poc.modules.poc.domain.entities.PocEntity;
//import im.aop.loggers.advice.around.LogAround;
import lombok.val;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Service
public class PocReactiveServiceImpl implements PocReactiveService {


    @Override
    public Mono<PocDto> getPocData1(String name)  {

        return  Mono.just(name)
                .map(n->new PocEntity(n,"Dobracina"))
                .flatMap(x->((x.getName().equals("Pera")
                        ? Mono.error(new ServiceException("Pera is Invalid name"))
                        : Mono.just(new PocDto(x.getName(), x.getAddress(),Thread.currentThread().getName())))));

    }



    @Override
    public Mono<PocDto> getPocData2(String name)  {

        System.out.println("Current Service Thread ID: " + Thread.currentThread().getName());
        val delayDuration = Duration.ofMillis(2000);

        return  Mono.delay(delayDuration)
               .then(Mono.just(name))
               .map(n->new PocEntity(n,"Dobracina"))
               .flatMap(x->((x.getName().equals("Pera")
                       ? Mono.error(new ServiceException("Pera is Invalid name"))
                       : Mono.just(new PocDto(x.getName(), x.getAddress(),Thread.currentThread().getName())))));

    }


    @Override
    public Mono<PocDto> getPocData3(String name)  {

        System.out.println("Current Service Thread ID: " + Thread.currentThread().getName());
        val delayDuration = Duration.ofMillis(2000);

        String one = "Perino ime je ruzno";
        String second = "Perino ime je kratko";
        Collection<String> errors = new ArrayList<>();
        errors.add(one);
        errors.add(second);
        if (Objects.equals(name, "Pera")) {
            ServiceExceptionDetails details = new ServiceExceptionDetails(errors);

            return  Mono.error(new ServiceException("Pera is Invalid name:",details));
        }
        if (Objects.equals(name, "Zika")) {

            return  Mono.defer(() ->Mono.error(new ServiceException("Zika is Invalid name")));
        }
        if (Objects.equals(name, "Steva")) {
           return  Mono.delay(delayDuration).then(Mono.error(new ServiceException("Steva is Invalid name")));
        }


        return Mono.delay(delayDuration)
                .then(Mono.just(name))
                .map(n->new PocEntity(n,"Dobracina"))
                .map(poc -> ( new PocDto(poc.getName(), poc.getAddress(),Thread.currentThread().getName())));

    }



    @Override
    public Mono<PocDto> getPocData4(String name)  {

        System.out.println("Current Service Thread ID: " + Thread.currentThread().getName());
        val delayDuration = Duration.ofMillis(2000);

        String one = "Perino ime je ruzno";
        String second = "Perino ime je kratko";
        Collection<String> errors = new ArrayList<>();
        errors.add(one);
        errors.add(second);
        if (Objects.equals(name, "Pera")) {
            ServiceExceptionDetails details = new ServiceExceptionDetails(errors);

            return  Mono.error(new ServiceException("Pera is Invalid name:",details));
        }
        if (Objects.equals(name, "Zika")) {

            return  Mono.defer(() ->Mono.error(new ServiceException("Zika is Invalid name")));
        }
        if (Objects.equals(name, "Steva")) {
            return  Mono.delay(delayDuration).then(Mono.error(new ServiceException("Steva is Invalid name")));
        }


        return Mono.just(name)
                .map(n->new PocEntity(n,"Dobracina"))
                .map(poc -> ( new PocDto(poc.getName(), poc.getAddress(),Thread.currentThread().getName())));

    }



}
