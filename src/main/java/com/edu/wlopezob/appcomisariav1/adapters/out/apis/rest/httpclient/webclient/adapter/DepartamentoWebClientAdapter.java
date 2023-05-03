package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter.base.GenericWebClientAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.departamento.DepartamentoWebClient;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.mappers.DepartamentoWebClientMapper;
import com.edu.wlopezob.appcomisariav1.application.ports.out.departamento.DepartamentoGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;

@RequiredArgsConstructor
public class DepartamentoWebClientAdapter extends GenericWebClientAdapter
  implements DepartamentoGetAllCallApiPort {

  private final DepartamentoWebClient departamentoWebClient;
  private final DepartamentoWebClientMapper mapper;

  @Override
  public Flux<Departamento> getAllDepartamento() {
    return departamentoWebClient.getAllDepartamento()
      .flatMapMany(list -> Flux.fromIterable(mapper.toListDominio(List.of(list))));
  }
}
