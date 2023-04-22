package com.edu.wlopezob.appcomisariav1.application.services;

import com.edu.wlopezob.appcomisariav1.application.ports.in.departamento.DepartamentoInsertAllUseCase;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.List;

@RequiredArgsConstructor
public class DepartamentoService implements DepartamentoInsertAllUseCase {
  private final DepartamentoDeleteAllPort departamentoDeleteAllPort;
  private final DepartamentoInsertAllPort departamentoInsertAllPort;
  private final DepartamentoGetAllCallApiPort departamentoGetAllCallApiPort;

  @Override
  public Flux<Departamento> insertAllDepartamento() {

    //delete departamentos
    departamentoDeleteAllPort.deleteAllDepartamento();

    //call api
    return departamentoInsertAllPort
      .insertAllDepartamento(departamentoGetAllCallApiPort.getAllDepartamento());
  }
}
