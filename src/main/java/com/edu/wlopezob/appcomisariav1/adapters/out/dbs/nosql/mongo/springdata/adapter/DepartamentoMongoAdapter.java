package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.adapter;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.repository.DepartamentoMongoRepository;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.adapter.base.GenericMongoAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.mappers.DepartamentoMongoMapper;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoGetAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DepartamentoMongoAdapter extends GenericMongoAdapter implements DepartamentoDeleteAllPort,
  DepartamentoGetAllPort, DepartamentoInsertAllPort {

  private final DepartamentoMongoRepository departamentoMongoRepository;
  private final DepartamentoMongoMapper departamentoMapper;

  @Override
  public Mono<Boolean> deleteAllDepartamento() {
    return departamentoMongoRepository.deleteAll().then(Mono.just(true));
  }

  @Override
  public Mono<List<Departamento>> getAllDepartamento() {
    return departamentoMongoRepository.findAll().map(departamentoMapper::toDominio).collectList();
  }

  @Override
  public Flux<Departamento> insertAllDepartamento(List<Departamento> departamentos) {
    var list = departamentos.stream().map(departamentoMapper::toEntity)
      .collect(Collectors.toList());
    return departamentoMongoRepository.insert(list).map(departamentoMapper::toDominio);
  }
}
