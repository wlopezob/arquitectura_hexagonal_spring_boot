package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.mappers;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.entity.DepartamentoDocument;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartamentoMongoMapperImpl implements DepartamentoMongoMapper {

  @Override
  public Departamento toDominio(DepartamentoDocument departamentoDocument) {
    return Departamento.builder()
      .idDpto(departamentoDocument.getIdDpto())
      .departamento(departamentoDocument.getDepartamento())
      .capital(departamentoDocument.getCapital())
      .build();
  }

  @Override
  public DepartamentoDocument toEntity(Departamento departamento) {
    return DepartamentoDocument.builder()
      .idDpto(departamento.getIdDpto())
      .departamento(departamento.getDepartamento())
      .capital(departamento.getCapital())
      .build();
  }

  @Override
  public List<Departamento> toListDominio(List<DepartamentoDocument> list) {
    return null;
  }

  @Override
  public List<DepartamentoDocument> toListEntity(List<Departamento> list) {
    return null;
  }
}
