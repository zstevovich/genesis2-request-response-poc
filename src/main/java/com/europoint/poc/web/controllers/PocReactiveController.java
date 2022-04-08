package com.europoint.poc.web.controllers;

import com.europoint.poc.modules.poc.api.appservicecontracts.dtos.PocDto;
import com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces.PocReactiveService;
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

@RestController("PocReactiveController")
@RequestMapping("pocreactive")
public class PocReactiveController {

    final PocReactiveService pocService;

    public PocReactiveController(PocReactiveService pocService) {
        this.pocService = pocService;
    }


    @GetMapping("/1/{name}")
    public Mono<ResponseEntity<PocDto>> getUserByName1(@PathVariable String name)  {
        System.out.println("Current Controller Thread ID: " + Thread.currentThread().getName());
        return Mono.justOrEmpty(name)
                .flatMap(x->pocService.getPocData1(x))
                .doOnError(x-> System.out.println("Error in Controller Thread ID: " + Thread.currentThread().getName()))
                .map(rsp->new ResponseEntity<PocDto>(rsp,HttpStatus.OK));
    }

    @GetMapping("/2/{name}")
    public Mono<ResponseEntity<PocDto>> getUserByName2(@PathVariable String name)  {
        System.out.println("Current Controller Thread ID: " + Thread.currentThread().getName());
        return Mono.justOrEmpty(name)
                .flatMap(x->pocService.getPocData2(x))
                .doOnError(x-> System.out.println("Error in Controller Thread ID: " + Thread.currentThread().getName()))
                .map(rsp->new ResponseEntity<PocDto>(rsp,HttpStatus.OK));
    }

    @GetMapping("/3/{name}")
    public Mono<ResponseEntity<PocDto>> getUserByName3(@PathVariable String name)  {
        System.out.println("Current Controller Thread ID: " + Thread.currentThread().getName());
        return Mono.justOrEmpty(name)
                .flatMap(x->pocService.getPocData3(x))
                .doOnError(x-> System.out.println("Error in Controller Thread ID: " + Thread.currentThread().getName()))
                .map(rsp->new ResponseEntity<PocDto>(rsp,HttpStatus.OK));
    }

    @GetMapping("/4/{name}")
    public Mono<ResponseEntity<PocDto>> getUserByName4(@PathVariable String name)  {
        System.out.println("Current Controller Thread ID: " + Thread.currentThread().getName());
        return Mono.justOrEmpty(name)
                .flatMap(x->pocService.getPocData4(x))
                .doOnError(x-> System.out.println("Error in Controller Thread ID: " + Thread.currentThread().getName()))
                .map(rsp->new ResponseEntity<PocDto>(rsp,HttpStatus.OK));
    }

    @GetMapping("/age/{age}")
    public Mono<ResponseEntity<String>> getUserAge(@PathVariable int age){
        System.out.println("Current Controller Thread ID: " + Thread.currentThread().getName());
        return Mono.just(ResponseEntity.ok("Your age is" + age));
    }

}
