package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.adapter;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.adapter.base.GenericMongoAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.mappers.DepartamentoMapper;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.repository.DepartamentoMongoRepository;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoGetAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class DepartamentoMongoAdapter extends GenericMongoAdapter implements DepartamentoDeleteAllPort,
  DepartamentoGetAllPort, DepartamentoInsertAllPort {

  private final DepartamentoMongoRepository departamentoMongoRepository;
  private final DepartamentoMapper departamentoMapper;

  @Override
  public Mono<Void> deleteAllDepartamento() {
    return departamentoMongoRepository.deleteAll();
  }

  @Override
  public Flux<Departamento> getAllDepartamento() {
    return departamentoMongoRepository.findAll().map(departamentoMapper::toDominio);
  }

  @Override
  public Flux<Departamento> insertAllDepartamento(List<Departamento> departamentos) {
    return departamentoMongoRepository.insert(departamentos.stream().map(departamentoMapper::toEntity)
      .toList()).map(departamentoMapper::toDominio);
  }
}
