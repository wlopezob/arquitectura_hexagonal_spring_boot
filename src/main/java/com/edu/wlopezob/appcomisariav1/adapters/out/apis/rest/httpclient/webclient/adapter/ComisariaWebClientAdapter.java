package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.adapter.base.GenericWebClientAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.comisaria.ComisariaWebClient;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.mappers.ComisariaWebClientMapper;
import com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria.ComisariaCountCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria.ComisariaGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.provincia.ProvinciaGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class ComisariaWebClientAdapter extends GenericWebClientAdapter
  implements ComisariaCountCallApiPort, ComisariaGetAllCallApiPort {

  private final ComisariaWebClient comisariaWebClient;
  private final ComisariaWebClientMapper mapper;

  @Override
  public Mono<Integer> getCountComisaria() {
    return comisariaWebClient.getAllCountComisaria();
  }

  @Override
  public Mono<List<Comisaria>> getAllComisaria(Integer count) {
    return comisariaWebClient.getAllComisaria(count).collectList()
      .map(mapper::toListDominio);
  }
}
