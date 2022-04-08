package com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces;

import com.europoint.poc.modules.poc.api.appservicecontracts.dtos.PocDto;
import reactor.core.publisher.Mono;

public interface PocService {
   PocDto getPocData(String name);
}
