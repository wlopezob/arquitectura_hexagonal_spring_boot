package com.edu.wlopezob.appcomisariav1.application.services;

import com.edu.wlopezob.appcomisariav1.application.ports.in.departamento.DepartamentoInsertAllUseCase;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService implements DepartamentoInsertAllUseCase {
  private final DepartamentoDeleteAllPort departamentoDeleteAllPort;
  private final DepartamentoInsertAllPort departamentoInsertAllPort;
  private final DepartamentoGetAllCallApiPort departamentoGetAllCallApiPort;

  @Override
  public Flux<Departamento> insertAllDepartamento() {

    return departamentoDeleteAllPort.deleteAllDepartamento().flux()
      .flatMap(t -> departamentoGetAllCallApiPort.getAllDepartamento()
        .collectList()
        .flatMapMany(t1 -> departamentoInsertAllPort.insertAllDepartamento(t1)));
  }

}
