package com.edu.wlopezob.appcomisariav1.application.ports.out.departamento;

import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import reactor.core.publisher.Flux;

import java.util.List;

@FunctionalInterface
public interface DepartamentoGetAllCallApiPort {
  Flux<Departamento> getAllDepartamento();
}
