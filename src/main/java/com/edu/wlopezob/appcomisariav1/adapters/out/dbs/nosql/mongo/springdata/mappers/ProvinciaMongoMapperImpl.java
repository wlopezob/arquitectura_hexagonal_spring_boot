package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.mappers;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.entity.ProvinciaDocument;
import com.edu.wlopezob.appcomisariav1.dominio.provincia.Provincia;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProvinciaMongoMapperImpl implements ProvinciaMongoMapper {
  @Override
  public Provincia toDominio(ProvinciaDocument provinciaDocument) {
    return Provincia.builder()
      .id(provinciaDocument.getId())
      .idDpto(provinciaDocument.getIdDpto())
      .idProv(provinciaDocument.getIdProv())
      .provincia(provinciaDocument.getProvincia())
      .capital(provinciaDocument.getCapital())
      .build();
  }

  @Override
  public ProvinciaDocument toEntity(Provincia provincia) {
    return ProvinciaDocument.builder()
      .idDpto(provincia.getIdDpto())
      .idProv(provincia.getIdProv())
      .provincia(provincia.getProvincia())
      .departamento(provincia.getDepartamento())
      .capital(provincia.getCapital())
      .build();
  }

  @Override
  public List<Provincia> toListDominio(List<ProvinciaDocument> list) {
    return list.stream().map(provinciaDocument -> Provincia.builder()
      .id(provinciaDocument.getId())
      .idDpto(provinciaDocument.getIdDpto())
      .idProv(provinciaDocument.getIdProv())
      .provincia(provinciaDocument.getProvincia())
      .departamento(provinciaDocument.getDepartamento())
      .capital(provinciaDocument.getCapital())
      .build()).collect(Collectors.toList());
  }

  @Override
  public List<ProvinciaDocument> toListEntity(List<Provincia> list) {
    return null;
  }
}
