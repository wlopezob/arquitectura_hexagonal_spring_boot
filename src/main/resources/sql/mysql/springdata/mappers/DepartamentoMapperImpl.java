package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.mappers;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.entity.DepartamentoEntity;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartamentoMapperImpl implements DepartamentoMapper {

  @Override
  public Departamento toDominio(DepartamentoEntity DepartamentoEntity) {
    return Departamento.builder()
      .idDpto(DepartamentoEntity.getIdDpto())
      .departamento(DepartamentoEntity.getDepartamento())
      .capital(DepartamentoEntity.getCapital())
      .build();
  }

  @Override
  public DepartamentoEntity toEntity(Departamento departamento) {
    return DepartamentoEntity.builder()
      .idDpto(departamento.getIdDpto())
      .departamento(departamento.getDepartamento())
      .capital(departamento.getCapital())
      .build();
  }

  @Override
  public List<Departamento> toListDominio(List<DepartamentoEntity> list) {
    return null;
  }

  @Override
  public List<DepartamentoEntity> toListEntity(List<Departamento> list) {
    return null;
  }
}
