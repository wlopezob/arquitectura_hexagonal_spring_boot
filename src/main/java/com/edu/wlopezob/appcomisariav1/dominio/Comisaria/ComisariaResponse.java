package com.edu.wlopezob.appcomisariav1.dominio.Comisaria;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComisariaResponse {
  private String id;
  private String idDpto;
  private String departamento;
  private String idProv;
  private String provincia;
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
