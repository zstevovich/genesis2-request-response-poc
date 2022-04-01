package com.europoint.poc.web.controllers;

import com.europoint.poc.modules.poc.api.appservicecontracts.dtos.PocDto;
import com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces.PocService;
import im.aop.loggers.advice.around.LogAround;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("PocController")
@RequestMapping("poc")
public class PocController {

    final PocService pocService;

    public PocController(PocService pocService) {
        this.pocService = pocService;
    }

    @LogAround
    @GetMapping("/{name}")
    public Mono<ResponseEntity<PocDto>> getUserById(@PathVariable String name) throws Exception {
        Mono<PocDto> user = pocService.getPocData(name);
        return user.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @LogAround
    @GetMapping("/age/{age}")
    public Mono<ResponseEntity<String>> getUserAge(@PathVariable int age){
        return Mono.just(ResponseEntity.ok("Your age is" + age));
    }

}
