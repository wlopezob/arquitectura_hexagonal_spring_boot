package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.comisaria;

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
public class ComisariaAttributes {
  @JsonProperty(value = "objectid")
  private int objectId;
  @JsonProperty(value = "id_dpto")
  private String idDpto;
  private String departamento;
  @JsonProperty(value = "id_prov")
  private String idProv;
  private String provincia;
  @JsonProperty(value = "id_dist")
  private String idDist;
  private String distrito;
  private String comisaria;
  @JsonProperty(value = "zona_utm")
  private String zonaUtm;
  private String categoria;

}
