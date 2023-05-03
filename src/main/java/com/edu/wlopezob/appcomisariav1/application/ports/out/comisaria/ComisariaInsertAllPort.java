package com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria;

import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;
import reactor.core.publisher.Flux;

import java.util.List;

@FunctionalInterface
public interface ComisariaInsertAllPort {
  Flux<Comisaria> insertAllComisaria(List<Comisaria> comisarias);
}
