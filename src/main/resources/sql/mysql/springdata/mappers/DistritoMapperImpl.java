package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.mappers;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.entity.DistritoEntity;
import com.edu.wlopezob.appcomisariav1.dominio.distrito.Distrito;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistritoMapperImpl implements DistritoMapper {
  @Override
  public Distrito toDominio(DistritoEntity DistritoEntity) {
    return Distrito.builder()
      .id(DistritoEntity.getId().toString())
      .idDpto(DistritoEntity.getIdDpto())
      .idProv(DistritoEntity.getIdProv())
      .idDist(DistritoEntity.getIdDist())
      .departamento(DistritoEntity.getDepartamento())
      .provincia(DistritoEntity.getProvincia())
      .distrito(DistritoEntity.getDistrito())
      .capital(DistritoEntity.getCapital())
      .build();
  }

  @Override
  public DistritoEntity toEntity(Distrito distrito) {
    return DistritoEntity.builder()
      .idDpto(distrito.getIdDpto())
      .idProv(distrito.getIdProv())
      .idDist(distrito.getIdDist())
      .departamento(distrito.getDepartamento())
      .provincia(distrito.getProvincia())
      .distrito(distrito.getDistrito())
      .capital(distrito.getCapital())
      .build();
  }

  @Override
  public List<Distrito> toListDominio(List<DistritoEntity> list) {
    return null;
  }

  @Override
  public List<DistritoEntity> toListEntity(List<Distrito> list) {
    return null;
  }
}
