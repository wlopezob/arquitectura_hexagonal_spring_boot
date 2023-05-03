package com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.exceptions;

import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.constants.APIConstants;
import com.edu.wlopezob.appcomisariav1.dominio.exception.ApiException;
import com.edu.wlopezob.appcomisariav1.dominio.exception.DataApiException;
import com.edu.wlopezob.appcomisariav1.dominio.exception.ErrorCategory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalControlAdvice {
  /**
   * Captura los errores ApiException y personaliza el ResponseEntity.
   *
   * @param ex ApiException Error
   * @return ResponseEntity del error personalizado
   */
  @ExceptionHandler(ApiException.class)
  public ResponseEntity<Object> handlerApiException(ApiException ex) {
    log.error("{}", ExceptionUtils.getStackTrace(ex));
    Optional<DataApiException> dataApiException = Optional.ofNullable(ex)
      .map(t -> returnDataApiException(t)
        .details(mapToDetails(t.getDetails()))
        .build()
      );
    return new ResponseEntity(dataApiException, HttpStatus.valueOf(ex.getHttpStatus()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handlerApiException(Exception ex) {
    String stackTrace = ExceptionUtils.getStackTrace(ex);
    log.error("{}", stackTrace);
    DataApiException dataApiException = DataApiException.builder()
      .code(String.valueOf(ErrorCategory.UNEXPECTED))
      .description(String.format("%s, %s", ex.getMessage(), stackTrace))
      .httpStatus(ErrorCategory.UNEXPECTED.getHttpStatus())
      .component(APIConstants.COMPONENT).build();
    return new ResponseEntity(dataApiException, HttpStatus.valueOf(dataApiException.getHttpStatus()));
  }

  /**
   * Mapea los detalles del ApiException.
   *
   * @param apiExceptions ApiException Error
   * @return
   */
  private List<DataApiException> mapToDetails(List<ApiException> apiExceptions) {
    return Optional.ofNullable(apiExceptions).isPresent()
      ? apiExceptions.stream().map(ex -> returnDataApiException(ex)
        .build())
      .collect(Collectors.toList())
      : null;
  }

  /**
   * Construye DataApiExceptionBuilder.
   *
   * @param apiException ApiException Error
   * @return DataApiExceptionBuilder
   */
  private DataApiException.DataApiExceptionBuilder returnDataApiException(
    ApiException apiException) {
    return DataApiException.builder()
      .code(String.valueOf(apiException.getCode()))
      .description(apiException.getDescription())
      .httpStatus(apiException.getHttpStatus())
      .component(apiException.getComponent());
  }
}
