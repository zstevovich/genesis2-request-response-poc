package com.europoint.poc.web.controllers;

import com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces.PocService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("PocController")
@RequestMapping("poc")
public class PocController {

    final PocService pocService;


    public PocController(PocService pocService) {
        this.pocService = pocService;
    }
}
