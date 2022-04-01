package com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces;

import com.europoint.poc.modules.poc.api.appservicecontracts.dtos.PocDto;
import reactor.core.publisher.Mono;

public interface PocService {
    Mono<PocDto> getPocData(String name) throws Exception;
}
