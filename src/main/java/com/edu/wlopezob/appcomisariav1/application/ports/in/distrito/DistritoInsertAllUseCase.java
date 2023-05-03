package com.edu.wlopezob.appcomisariav1.application.ports.in.distrito;

import com.edu.wlopezob.appcomisariav1.dominio.distrito.Distrito;
import com.edu.wlopezob.appcomisariav1.dominio.provincia.Provincia;
import reactor.core.publisher.Flux;

import java.util.List;

@FunctionalInterface
public interface DistritoInsertAllUseCase {
  Flux<Distrito> insertAllDistrito();
}
