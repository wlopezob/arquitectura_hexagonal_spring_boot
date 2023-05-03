package com.edu.wlopezob.appcomisariav1.application.services;

import com.edu.wlopezob.appcomisariav1.application.ports.in.distrito.DistritoInsertAllUseCase;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoGetAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.distrito.DistritoDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.distrito.DistritoGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.distrito.DistritoInsertAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinciaGetAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.distrito.Distrito;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DistritoService implements DistritoInsertAllUseCase {
  private final DistritoGetAllCallApiPort distritoGetAllCallApiPort;
  private final DistritoDeleteAllPort distritoDeleteAllPort;
  private final DistritoInsertAllPort distritoInsertAllPort;
  private final ProvinciaGetAllPort provinciaGetAllPort;

  @Override
  public Flux<Distrito> insertAllDistrito() {
    // delete distrito
    return distritoDeleteAllPort.deleteAllDistrito().flux()
      .flatMap(b -> provinciaGetAllPort.getAllProvincia().flatMapIterable(t -> t)
        .flatMap(prov -> distritoGetAllCallApiPort.getAllDistrito(prov.getIdProv())
          .flatMap(list -> distritoInsertAllPort.insertAllDistrito(list))))
      .flatMapIterable(t -> t);
  }
}
