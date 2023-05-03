package com.edu.wlopezob.appcomisariav1.application.services;

import com.edu.wlopezob.appcomisariav1.application.ports.in.provincia.ProvinciaInsertAllUseCase;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoGetAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinciaGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinicaDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinicaInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.provincia.Provincia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProvinciaService implements ProvinciaInsertAllUseCase {
  private final ProvinciaGetAllCallApiPort provinciaGetAllCallApiPort;
  private final ProvinicaDeleteAllPort provinicaDeleteAllPort;
  private final DepartamentoGetAllPort departamentoGetAllPort;
  private final ProvinicaInsertAllPort provinicaInsertAllPort;

  @Override
  public Flux<Provincia> insertAllProvincia() {
    return provinicaDeleteAllPort.deleteAllProvincia().flux()
      .flatMap(b -> departamentoGetAllPort.getAllDepartamento().flatMapIterable(t -> t)
        .flatMap(dpto -> provinciaGetAllCallApiPort.getAllProvincia(dpto.getIdDpto())
          .flatMap(list -> provinicaInsertAllPort.insertAllProvincia(list))).flatMapIterable(t -> t));
  }
}
