package com.edu.wlopezob.appcomisariav1.application.ports.in.comisaria;

import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;
import reactor.core.publisher.Flux;

import java.util.List;

@FunctionalInterface
public interface ComisariaGetAllUseCase {
  Flux<Comisaria> getAllComisaria();
}
