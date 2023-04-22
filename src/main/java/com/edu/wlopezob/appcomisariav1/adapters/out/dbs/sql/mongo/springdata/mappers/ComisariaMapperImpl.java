package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.mappers;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.entity.ComisariaDocument;
import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComisariaMapperImpl implements ComisariaMapper {
  @Override
  public Comisaria toDominio(ComisariaDocument comisariaDocument) {
    return Comisaria.builder()
      .idDpto(comisariaDocument.getIdDpto())
      .departamento(comisariaDocument.getDepartamento())
      .idProv(comisariaDocument.getIdProv())
      .provincia(comisariaDocument.getProvincia())
      .idDist(comisariaDocument.getIdDist())
      .comisaria(comisariaDocument.getComisaria())
      .categoria(comisariaDocument.getCategoria())
      .macroregpol(comisariaDocument.getMacroregpol())
      .regionpol(comisariaDocument.getRegionpol())
      .resolucion(comisariaDocument.getResolucion())
      .build();
  }

  @Override
  public ComisariaDocument toEntity(Comisaria comisaria) {
    return ComisariaDocument.builder()
      .idDpto(comisaria.getIdDpto())
      .departamento(comisaria.getDepartamento())
      .idProv(comisaria.getIdProv())
      .provincia(comisaria.getProvincia())
      .idDist(comisaria.getIdDist())
      .comisaria(comisaria.getComisaria())
      .categoria(comisaria.getCategoria())
      .macroregpol(comisaria.getMacroregpol())
      .regionpol(comisaria.getRegionpol())
      .resolucion(comisaria.getResolucion())
      .build();
  }

  @Override
  public List<Comisaria> toListDominio(List<ComisariaDocument> list) {
    return null;
  }

  @Override
  public List<ComisariaDocument> toListEntity(List<Comisaria> list) {
    return null;
  }
}
