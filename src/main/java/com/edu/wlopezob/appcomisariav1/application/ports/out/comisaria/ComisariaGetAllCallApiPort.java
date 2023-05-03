package com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria;

import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@FunctionalInterface
public interface ComisariaGetAllCallApiPort {
  Mono<List<Comisaria>> getAllComisaria(Integer count);
}
