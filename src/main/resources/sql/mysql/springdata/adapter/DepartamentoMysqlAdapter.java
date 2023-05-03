package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.adapter;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.adapter.base.GenericMysqlAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.mappers.DepartamentoMapper;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.repository.DepartamentoMysqlRepository;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoGetAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DepartamentoMysqlAdapter extends GenericMysqlAdapter implements DepartamentoDeleteAllPort,
  DepartamentoGetAllPort, DepartamentoInsertAllPort {

  private final DepartamentoMysqlRepository repository;
  private final DepartamentoMapper departamentoMapper;

  @Override
  public Mono<Boolean> deleteAllDepartamento() {
    repository.deleteAll();
    return Mono.defer(() -> {
      repository.deleteAll();
      return Mono.empty();
    });
  }

  @Override
  public Flux<Departamento> getAllDepartamento() {
    return Flux.fromIterable(repository.findAll().stream()
      .map(departamentoMapper::toDominio).collect(Collectors.toList()));
  }

  @Override
  public Flux<Departamento> insertAllDepartamento(List<Departamento> departamentos) {
    return Flux.fromIterable(repository
      .saveAll(departamentos.stream().map(departamentoMapper::toEntity)
        .collect(Collectors.toList()))
      .stream().map(departamentoMapper::toDominio)
      .collect(Collectors.toList()));
  }
}
