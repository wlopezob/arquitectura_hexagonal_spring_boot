package com.edu.wlopezob.appcomisariav1.dominio.provincia;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Provincia {
  private String id;
  private String idDpto;
  private String idProv;
  private String provincia;
  private String departamento;
  private String capital;
}
