package com.edu.wlopezob.appcomisariav1.dominio.departamento;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartamentoResponse {
  private String id;
  private String idDpto;
  private String departamento;
  private String capital;
}
