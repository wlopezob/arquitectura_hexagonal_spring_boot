package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.entity;


import com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.entity.base.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "DepartamentoEntity")
@Table(name = "departamento")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoEntity extends GenericEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "id_dpto")
  private String idDpto;
  private String departamento;
  private String capital;
}
