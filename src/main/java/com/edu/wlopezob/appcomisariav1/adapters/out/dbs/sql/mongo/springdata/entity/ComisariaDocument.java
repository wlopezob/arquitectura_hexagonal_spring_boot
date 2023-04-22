package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.entity;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mongo.springdata.entity.base.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "comisaria")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComisariaDocument extends GenericEntity {
  @Id
  private String id;
  @Field("id_dpto")
  private String idDpto;
  private String departamento;
  @Field("id_prov")
  private String idProv;
  private String provincia;
  @Field("id_dist")
  private String idDist;
  private String distrito;
  private String comisaria;
  private String categoria;
  private String macroregpol;
  private String regionpol;
  private String resolucion;
  private String x;
  private String y;
}
