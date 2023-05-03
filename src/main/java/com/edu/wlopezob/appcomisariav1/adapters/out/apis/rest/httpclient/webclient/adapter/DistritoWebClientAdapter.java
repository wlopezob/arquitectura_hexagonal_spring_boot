package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter.base.GenericWebClientAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.distrito.DistritoWebClient;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.mappers.DistritoWebClientMapper;
import com.edu.wlopezob.appcomisariav1.application.ports.out.distrito.DistritoGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.dominio.distrito.Distrito;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class DistritoWebClientAdapter extends GenericWebClientAdapter
  implements DistritoGetAllCallApiPort {

  private final DistritoWebClient distritoWebClient;
  private final DistritoWebClientMapper mapper;

  @Override
  public Mono<List<Distrito>> getAllDistrito(String codProv) {
    return distritoWebClient.getAllDistrito(codProv).collectList()
      .map(mapper::toListDominio);
  }
}
