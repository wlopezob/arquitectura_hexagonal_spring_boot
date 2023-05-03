package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.mappers;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.comisaria.ComisariaResponse;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.departamento.DepartamentoResponse;
import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComisariaWebClientMapperImpl implements ComisariaWebClientMapper{
  @Override
  public Comisaria toDominio(ComisariaResponse comisariaResponse) {
    return null;
  }

  @Override
  public ComisariaResponse toEntity(Comisaria comisaria) {
    return null;
  }

  @Override
  public List<Comisaria> toListDominio(List<ComisariaResponse> list) {
    return list.get(0).getFeatures().stream()
      .map(comi -> Comisaria.builder()
        .idDpto(comi.getAttributes().getIdDpto())
        .departamento(comi.getAttributes().getDepartamento())
        .idProv(comi.getAttributes().getIdProv())
        .provincia(comi.getAttributes().getProvincia())
        .idDist(comi.getAttributes().getIdDist())
        .distrito(comi.getAttributes().getDistrito())
        .comisaria(comi.getAttributes().getComisaria())
        .zonaUtm(comi.getAttributes().getZonaUtm())
        .categoria(comi.getAttributes().getCategoria())
        .build())
      .collect(Collectors.toList());
  }

  @Override
  public List<ComisariaResponse> toListEntity(List<Comisaria> list) {
    return null;
  }
}
