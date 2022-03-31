package com.europoint.poc.modules.poc.app.services;

import com.europoint.poc.modules.poc.api.appservicecontracts.dtos.PocDto;
import com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces.PocService;
import com.europoint.poc.modules.poc.domain.entities.PocEntity;
import org.springframework.stereotype.Service;

@Service
public class PocServiceImpl implements PocService {
    @Override
    public PocDto getPocData() {
        PocEntity poc = new PocEntity("Europoint","Dobracina");
        return new PocDto(poc.getName(),poc.getAddress());
    }
}
