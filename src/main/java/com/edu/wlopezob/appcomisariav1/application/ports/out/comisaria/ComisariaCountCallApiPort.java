package com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria;

import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;
import reactor.core.publisher.Mono;

import java.util.List;

@FunctionalInterface
public interface ComisariaCountCallApiPort {
  Mono<Integer> getCountComisaria();
}
