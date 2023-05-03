package com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.mappers;

import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.dto.response.DepartamentoResponse;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartamentoResponseMapperImpl implements DepartamentoResponseMapper {
  @Override
  public Departamento toDomino(DepartamentoResponse departamentoResponse) {
    return Departamento.builder()
      .id(departamentoResponse.getId())
      .idDpto(departamentoResponse.getIdDpto())
      .departamento(departamentoResponse.getDepartamento())
      .capital(departamentoResponse.getCapital())
      .build();
  }

  @Override
  public DepartamentoResponse toResponse(Departamento departamento) {
    return DepartamentoResponse.builder()
      .id(departamento.getId())
      .idDpto(departamento.getIdDpto())
      .departamento(departamento.getDepartamento())
      .capital(departamento.getCapital())
      .build();
  }

  @Override
  public List<Departamento> toListDomino(List<DepartamentoResponse> list) {
    return null;
  }

  @Override
  public List<DepartamentoResponse> toListResponse(List<Departamento> listD) {
    return null;
  }
}
