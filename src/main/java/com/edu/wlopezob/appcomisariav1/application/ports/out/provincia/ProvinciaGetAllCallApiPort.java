package com.edu.wlopezob.appcomisariav1.application.ports.out.provincia;

import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import com.edu.wlopezob.appcomisariav1.dominio.provincia.Provincia;
import reactor.core.publisher.Flux;

import java.util.List;

@FunctionalInterface
public interface ProvinciaGetAllCallApiPort {
  Flux<Provincia> getAllProvincia(String idDpto);
}
