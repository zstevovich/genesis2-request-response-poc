package com.europoint.poc.web.controllers;

import com.europoint.poc.modules.poc.api.appservicecontracts.dtos.PocDto;
import com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces.PocService;
//import im.aop.loggers.advice.around.LogAround;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController("PocController")
@RequestMapping("poc")
public class PocController {

    final PocService pocService;

    public PocController(PocService pocService) {
        this.pocService = pocService;
    }

    //@LogAround
    @GetMapping("/{name}")
    public Mono<ResponseEntity<PocDto>> getUserByName(@PathVariable String name) throws Exception {
        System.out.println("Current Controller Thread ID: " + Thread.currentThread().getName());
        return Mono.justOrEmpty(name)
                .flatMap(x->Mono.just(pocService.getPocData(x)))
                .map(rsp->new ResponseEntity<PocDto>(rsp,HttpStatus.OK));
    }

    @GetMapping("/2/{name}")
    public Mono<ResponseEntity<PocDto>> getUserByName2(@PathVariable String name)  {
        System.out.println("Current Controller Thread ID: " + Thread.currentThread().getName());
        return Mono.fromCallable(() -> new ResponseEntity<PocDto>(pocService.getPocData(name),HttpStatus.OK)).subscribeOn(Schedulers.boundedElastic());

    }

    //@LogAround
    @GetMapping("/age/{age}")
    public Mono<ResponseEntity<String>> getUserAge(@PathVariable int age){
        return Mono.just(ResponseEntity.ok("Your age is" + age));
    }

}
