package com.edu.wlopezob.appcomisariav1.application.services;

import com.edu.wlopezob.appcomisariav1.application.ports.in.provincia.ProvinciaInsertAllUseCase;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoGetAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinciaGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinicaDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinicaInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.provincia.Provincia;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.List;

@RequiredArgsConstructor
public class ProvinciaService implements ProvinciaInsertAllUseCase {
  private final ProvinciaGetAllCallApiPort provinciaGetAllCallApiPort;
  private final ProvinicaDeleteAllPort provinicaDeleteAllPort;
  private final DepartamentoGetAllPort departamentoGetAllPort;
  private final ProvinicaInsertAllPort provinicaInsertAllPort;

  @Override
  public Flux<Provincia> insertAllProvincia(List<Provincia> provincias) {
    // delete provincias
    provinicaDeleteAllPort.deleteAllProvincia();

    // get all departamento db
    return departamentoGetAllPort.getAllDepartamento()
      .flatMap(dpto -> provinciaGetAllCallApiPort.getAllProvincia(dpto.getIdDpto()))
      .collectList().flux()
      .flatMap(provinicaInsertAllPort::insertAllProvincia);


  }
}
