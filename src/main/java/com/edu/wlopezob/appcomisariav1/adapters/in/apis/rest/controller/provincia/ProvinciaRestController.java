package com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.provincia;

import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.dto.response.ProvinciaResponse;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

public interface ProvinciaRestController {

  @GetMapping
  Flux<ProvinciaResponse> getAll();
}
