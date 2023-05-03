package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.provincia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProvinciaAttributes {
  @JsonProperty(value = "objectid")
  private int objectId;
  @JsonProperty(value = "id_dpto")
  private String idDpto;
  @JsonProperty(value = "id_prov")
  private String idPov;
  private String departamento;
  private String provincia;
  private String capital;
  private String fuente;
}