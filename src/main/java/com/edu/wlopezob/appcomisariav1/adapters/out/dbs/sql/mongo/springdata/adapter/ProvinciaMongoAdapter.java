package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.adapter;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.adapter.base.GenericMongoAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.entity.ProvinciaDocument;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.mappers.ProvinciaMapper;
import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.repository.ProvinciaMongoRepository;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinciaGetAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinicaDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinicaInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.provincia.Provincia;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProvinciaMongoAdapter extends GenericMongoAdapter implements ProvinciaGetAllPort, ProvinicaDeleteAllPort,
  ProvinicaInsertAllPort {

  private final ProvinciaMongoRepository provinciaMongoRepository;
  private final ProvinciaMapper provinciaMapper;

  @Override
  public Flux<Provincia> getAllProvincia() {
    return provinciaMongoRepository.findAll().map(provinciaMapper::toDominio);
  }

  @Override
  public Mono<Void> deleteAllProvincia() {
    return provinciaMongoRepository.deleteAll();
  }

  @Override
  public Flux<Provincia> insertAllProvincia(List<Provincia> list) {
    return provinciaMongoRepository.insert(list.stream()
        .map(provinciaMapper::toEntity).collect(Collectors.toList()))
      .map(provinciaMapper::toDominio);
  }
}
