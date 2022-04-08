package com.europoint.poc.modules.poc.api.appservicecontracts.serviceinterfaces;

import com.europoint.poc.modules.poc.api.appservicecontracts.dtos.PocDto;
import reactor.core.publisher.Mono;

public interface PocReactiveService {
   Mono<PocDto> getPocData1(String name);
   Mono<PocDto> getPocData2(String name);
   Mono<PocDto> getPocData3(String name);
   Mono<PocDto> getPocData4(String name);
}
