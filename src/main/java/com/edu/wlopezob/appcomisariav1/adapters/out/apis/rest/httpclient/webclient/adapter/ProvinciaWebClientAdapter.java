package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter.base.GenericWebClientAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.departamento.DepartamentoWebClient;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.provincia.ProvinciaWebClient;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.mappers.DepartamentoWebClientMapper;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.mappers.ProvinciaWebClientMapper;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinciaGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.dominio.provincia.Provincia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class ProvinciaWebClientAdapter extends GenericWebClientAdapter
  implements ProvinciaGetAllCallApiPort {

  private final ProvinciaWebClient provinciaWebClient;
  private final ProvinciaWebClientMapper mapper;

  @Override
  public Mono<List<Provincia>> getAllProvincia(String idDpto) {
    return provinciaWebClient.getAllDepartamento(idDpto).collectList()
      .map(mapper::toListDominio);
  }
}
