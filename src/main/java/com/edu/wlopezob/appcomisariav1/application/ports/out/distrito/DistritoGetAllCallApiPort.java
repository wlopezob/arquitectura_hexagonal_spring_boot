package com.edu.wlopezob.appcomisariav1.application.ports.out.distrito;

import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import com.edu.wlopezob.appcomisariav1.dominio.distrito.Distrito;
import reactor.core.publisher.Mono;

import java.util.List;

@FunctionalInterface
public interface DistritoGetAllCallApiPort {
  Mono<List<Distrito>> getAllDistrito(String idProv);
}
