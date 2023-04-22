package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.adapter;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.adapter.base.GenericMongoAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.mappers.DistritoMapper;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.repository.DistritoMongoRepository;
import com.edu.wlopezob.appcomisariav1.application.ports.out.distrito.DistritoDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.distrito.DistritoInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.distrito.Distrito;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DistritoMongoAdapter extends GenericMongoAdapter implements DistritoInsertAllPort,
  DistritoDeleteAllPort {
  private final DistritoMongoRepository distritoMongoRepository;
  private final DistritoMapper distritoMapper;

  @Override
  public Mono<Void> deleteAllDistrito() {
    return distritoMongoRepository.deleteAll();
  }

  @Override
  public Flux<Distrito> insertAllDistrito(List<Distrito> list) {
    return distritoMongoRepository.insert(list.stream().map(distritoMapper::toEntity).collect(Collectors.toList()))
      .map(distritoMapper::toDominio);
  }

}
