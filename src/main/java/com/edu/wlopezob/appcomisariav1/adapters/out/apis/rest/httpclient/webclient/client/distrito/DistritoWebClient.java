package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.distrito;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.distrito.DistritoResponse;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.provincia.ProvinciaResponse;
import reactor.core.publisher.Flux;

public interface DistritoWebClient {
  Flux<DistritoResponse> getAllDistrito(String codProv);
}
