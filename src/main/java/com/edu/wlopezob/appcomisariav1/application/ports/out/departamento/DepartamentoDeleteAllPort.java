package com.edu.wlopezob.appcomisariav1.application.ports.out.departamento;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DepartamentoDeleteAllPort {
  Mono<Boolean> deleteAllDepartamento();
}
