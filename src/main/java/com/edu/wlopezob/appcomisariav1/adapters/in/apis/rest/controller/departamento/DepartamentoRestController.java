package com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.departamento;

import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.dto.response.DepartamentoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

public interface DepartamentoRestController {

  @GetMapping
  Flux<DepartamentoResponse> getAll();
}
