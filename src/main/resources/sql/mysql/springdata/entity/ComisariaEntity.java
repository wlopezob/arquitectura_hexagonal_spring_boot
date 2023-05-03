package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.entity;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.entity.base.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "ComisariaEntity")
@Table(name = "comisaria")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComisariaEntity extends GenericEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "id_dpto")
  private String idDpto;
  private String departamento;
  @Column(name = "id_prov")
  private String idProv;
  private String provincia;
  @Column(name = "id_dist")
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
