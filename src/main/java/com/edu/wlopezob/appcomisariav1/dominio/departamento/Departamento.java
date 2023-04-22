package com.edu.wlopezob.appcomisariav1.dominio.departamento;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departamento {
  private String id;
  private String idDpto;
  private String departamento;
  private String capital;
}
