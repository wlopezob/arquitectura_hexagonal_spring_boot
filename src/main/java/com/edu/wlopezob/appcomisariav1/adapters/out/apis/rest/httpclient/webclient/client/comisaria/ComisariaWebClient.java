package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.comisaria;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.comisaria.ComisariaResponse;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.provincia.ProvinciaResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ComisariaWebClient {
  Mono<Integer> getAllCountComisaria();
  Flux<ComisariaResponse> getAllComisaria(int count);
}
