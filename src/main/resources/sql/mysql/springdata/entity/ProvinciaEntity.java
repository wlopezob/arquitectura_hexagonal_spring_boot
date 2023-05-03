package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.entity;

import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.entity.base.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "ProvinciaEntity")
@Table(name = "provincia")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinciaEntity extends GenericEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "id_dpto")
  private String idDpto;
  @Column(name = "id_prov")
  private String idProv;
    private String provincia;
  private String capital;
}
