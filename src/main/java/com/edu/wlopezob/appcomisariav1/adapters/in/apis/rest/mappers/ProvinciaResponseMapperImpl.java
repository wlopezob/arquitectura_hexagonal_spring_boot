package com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.mappers;

import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.dto.response.ProvinciaResponse;
import com.edu.wlopezob.appcomisariav1.dominio.provincia.Provincia;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProvinciaResponseMapperImpl implements ProvinciaResponseMapper {
  @Override
  public Provincia toDomino(ProvinciaResponse provinciaResponse) {
    return Provincia.builder()
      .idProv(provinciaResponse.getIdProv())
      .idDpto(provinciaResponse.getIdDpto())
      .departamento(provinciaResponse.getDepartamento())
      .provincia(provinciaResponse.getProvincia())
      .capital(provinciaResponse.getCapital())
      .build();
  }

  @Override
  public ProvinciaResponse toResponse(Provincia departamento) {
    return ProvinciaResponse.builder()
      .idDpto(departamento.getIdDpto())
      .idProv(departamento.getIdProv())
      .provincia(departamento.getProvincia())
      .departamento(departamento.getDepartamento())
      .capital(departamento.getCapital())
      .build();
  }

  @Override
  public List<Provincia> toListDomino(List<ProvinciaResponse> list) {
    return null;
  }

  @Override
  public List<ProvinciaResponse> toListResponse(List<Provincia> listD) {
    return null;
  }

}
