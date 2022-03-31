package com.europoint.poc.modules.poc.app.services;

import com.europoint.poc.modules.poc.api.appservicecontracts.dtos.PocDto;
import com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces.PocService;

public class PocServiceImpl implements PocService {
    @Override
    public PocDto getData() {
        return new PocDto();
    }
}
