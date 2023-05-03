package com.edu.wlopezob.appcomisariav1.adapters.out.dbs.sql.mysql.springdata.entity.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class GenericEntity {
  private String estado;
}
