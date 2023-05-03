package com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.comisaria;

import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.dto.response.ComisariaResponse;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

public interface ComisariaRestController {

  @GetMapping
  Flux<ComisariaResponse> getAll();
}
