package com.edu.wlopezob.appcomisariav1.application.services;

import com.edu.wlopezob.appcomisariav1.application.ports.in.distrito.DistritoInsertAllUseCase;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoGetAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.distrito.DistritoDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.distrito.DistritoGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.distrito.DistritoInsertAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinciaGetAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.distrito.Distrito;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DistritoService implements DistritoInsertAllUseCase {
  private final DistritoGetAllCallApiPort distritoGetAllCallApiPort;
  private final DistritoDeleteAllPort distritoDeleteAllPort;
  private final DistritoInsertAllPort distritoInsertAllPort;
  private final ProvinciaGetAllPort provinciaGetAllPort;

  @Override
  public Flux<Distrito> insertAllDistrito(List<Distrito> distritos) {
    // delete distrito
    distritoDeleteAllPort.deleteAllDistrito();

    // get all provincia db
    return provinciaGetAllPort.getAllProvincia()
      .flatMap(prov -> distritoGetAllCallApiPort.getAllDistrito(prov.getIdProv()))
      .concatWith(Flux.fromIterable(new ArrayList<>()))
      .flatMap(distritoInsertAllPort::insertAllDistrito);
  }
}
