package com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.distrito;

import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.dto.response.DistritoResponse;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.dto.response.ProvinciaResponse;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

public interface DistritoRestController {

  @GetMapping
  Flux<DistritoResponse> getAll();
}
