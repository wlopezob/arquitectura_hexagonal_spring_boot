package com.edu.wlopezob.appcomisariav1.dominio.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataApiException {
  private String code;
  private String description;
  private String component;
  private List<DataApiException> details;
  private int httpStatus;
}

