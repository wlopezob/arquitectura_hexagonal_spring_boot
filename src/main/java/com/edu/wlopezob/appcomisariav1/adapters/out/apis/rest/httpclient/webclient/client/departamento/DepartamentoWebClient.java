package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.departamento;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.departamento.DepartamentoResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DepartamentoWebClient {
  Mono<DepartamentoResponse> getAllDepartamento();
}
