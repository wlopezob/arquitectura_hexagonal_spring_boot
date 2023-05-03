package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.mappers;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.departamento.DepartamentoResponse;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.provincia.ProvinciaResponse;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import com.edu.wlopezob.appcomisariav1.dominio.provincia.Provincia;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProvinciaWebClientMapperImpl implements ProvinciaWebClientMapper{
  @Override
  public Provincia toDominio(ProvinciaResponse provinciaResponse) {
    return null;
  }

  @Override
  public ProvinciaResponse toEntity(Provincia provincia) {
    return null;
  }

  @Override
  public List<Provincia> toListDominio(List<ProvinciaResponse> list) {
    return list.get(0).getFeatures().stream()
      .map(dpto -> Provincia.builder()
        .idDpto(dpto.getAttributes().getIdDpto())
        .idProv(dpto.getAttributes().getIdPov())
        .provincia(dpto.getAttributes().getProvincia())
        .departamento(dpto.getAttributes().getDepartamento())
        .capital(dpto.getAttributes().getCapital())
        .build())
      .collect(Collectors.toList());
  }

  @Override
  public List<ProvinciaResponse> toListEntity(List<Provincia> list) {
    return null;
  }
}
