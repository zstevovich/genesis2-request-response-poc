package com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces;

import com.europoint.poc.modules.poc.api.appservicecontracts.dtos.PocDto;
import org.springframework.stereotype.Service;

@Service
public interface PocService {
    PocDto getData();
}
