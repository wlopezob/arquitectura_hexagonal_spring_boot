package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.entity;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.nosql.mongo.springdata.entity.base.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "provincia")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinciaDocument extends GenericEntity {
  @Id
  private String id;
  @Field("id_dpto")
  private String idDpto;
  @Field("id_prov")
  private String idProv;
  private String provincia;
  private String departamento;
  private String capital;
}
