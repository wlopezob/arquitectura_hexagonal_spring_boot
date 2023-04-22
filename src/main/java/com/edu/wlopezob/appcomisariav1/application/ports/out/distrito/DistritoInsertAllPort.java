package com.edu.wlopezob.appcomisariav1.application.ports.out.distrito;

import com.edu.wlopezob.appcomisariav1.dominio.distrito.Distrito;
import reactor.core.publisher.Flux;

import java.util.List;

@FunctionalInterface
public interface DistritoInsertAllPort {
  Flux<Distrito> insertAllDistrito(List<Distrito> list);
}
