package com.edu.wlopezob.appcomisariav1.application.ports.out.provincia;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.entity.ProvinciaDocument;
import com.edu.wlopezob.appcomisariav1.dominio.provincia.Provincia;
import reactor.core.publisher.Flux;

import java.util.List;

@FunctionalInterface
public interface ProvinicaInsertAllPort {
  Flux<Provincia> insertAllProvincia(List<Provincia> list);
}
