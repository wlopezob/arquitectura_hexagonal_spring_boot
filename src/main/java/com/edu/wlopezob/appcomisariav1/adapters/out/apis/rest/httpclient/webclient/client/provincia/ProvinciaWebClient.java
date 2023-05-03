package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.provincia;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.provincia.ProvinciaResponse;
import reactor.core.publisher.Flux;

public interface ProvinciaWebClient {
  Flux<ProvinciaResponse> getAllDepartamento(String codDpto);
}
