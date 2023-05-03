package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.adapter;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.repository.ProvinciaMongoRepository;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.adapter.base.GenericMongoAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.mappers.ProvinciaMongoMapper;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinciaGetAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinicaDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinicaInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.provincia.Provincia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProvinciaMongoAdapter extends GenericMongoAdapter implements ProvinciaGetAllPort, ProvinicaDeleteAllPort,
  ProvinicaInsertAllPort {

  private final ProvinciaMongoRepository provinciaMongoRepository;
  private final ProvinciaMongoMapper provinciaMapper;

  @Override
  public Mono<List<Provincia>> getAllProvincia() {
    return provinciaMongoRepository.findAll().map(provinciaMapper::toDominio)
      .collectList();
  }

  @Override
  public Mono<Boolean> deleteAllProvincia() {
    return provinciaMongoRepository.deleteAll().then(Mono.just(true));
  }

  @Override
  public Mono<List<Provincia>> insertAllProvincia(List<Provincia> list) {
    return provinciaMongoRepository.insert(list.stream()
        .map(provinciaMapper::toEntity).collect(Collectors.toList()))
      .collectList()
      .map(provinciaMapper::toListDominio);
  }
}
