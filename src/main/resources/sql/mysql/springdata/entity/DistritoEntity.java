package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.entity;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.entity.base.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "DistritoEntity")
@Table(name = "distrito")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DistritoEntity extends GenericEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "id_dist")
  private String idDist;
  @Column(name = "id_prov")
  private String idProv;
  @Column(name = "id_dpto")
  private String idDpto;
  private String departamento;
  private String provincia;
  private String distrito;
  private String capital;
}
