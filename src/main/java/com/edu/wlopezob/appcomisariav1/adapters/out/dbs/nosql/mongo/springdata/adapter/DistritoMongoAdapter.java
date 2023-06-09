package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.adapter;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.adapter.base.GenericMongoAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.mappers.DistritoMongoMapper;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.repository.DistritoMongoRepository;
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
  private final DistritoMongoMapper distritoMapper;

  @Override
  public Mono<Boolean> deleteAllDistrito() {
    return distritoMongoRepository.deleteAll().then(Mono.just(true));
  }

  @Override
  public Mono<List<Distrito>> insertAllDistrito(List<Distrito> list) {
    return distritoMongoRepository.insert(list.stream().map(distritoMapper::toEntity).collect(Collectors.toList()))
      .collectList()
      .map(distritoMapper::toListDominio);
  }

}
