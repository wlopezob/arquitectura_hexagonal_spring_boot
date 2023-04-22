package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.mappers;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.entity.DistritoDocument;
import com.edu.wlopezob.appcomisariav1.dominio.distrito.Distrito;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistritoMapperImpl implements DistritoMapper {
  @Override
  public Distrito toDominio(DistritoDocument distritoDocument) {
    return Distrito.builder()
      .id(distritoDocument.getId())
      .idDpto(distritoDocument.getIdDpto())
      .idProv(distritoDocument.getIdProv())
      .idDist(distritoDocument.getIdDist())
      .departamento(distritoDocument.getDepartamento())
      .provincia(distritoDocument.getProvincia())
      .distrito(distritoDocument.getDistrito())
      .capital(distritoDocument.getCapital())
      .build();
  }

  @Override
  public DistritoDocument toEntity(Distrito distrito) {
    return DistritoDocument.builder()
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
  public List<Distrito> toListDominio(List<DistritoDocument> list) {
    return null;
  }

  @Override
  public List<DistritoDocument> toListEntity(List<Distrito> list) {
    return null;
  }
}
