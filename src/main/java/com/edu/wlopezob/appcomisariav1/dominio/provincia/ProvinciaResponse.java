package com.edu.wlopezob.appcomisariav1.dominio.provincia;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProvinciaResponse {
  private String id;
  private String idDpto;
  private String idProv;
  private String String;
  private String provincia;
  private String capital;
}
