package com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.departamento;

import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.config.ApiProperties;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.base.GenericWebClient;
import com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.dto.departamento.DepartamentoResponse;
import com.edu.wlopezob.appcomisariav1.dominio.exception.ApiExceptionEnum;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

import static com.edu.wlopezob.appcomisariav1.adapters.out.apis.rest.httpclient.webclient.client.constants.Constants.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class DepartamentoWebClientImpl extends GenericWebClient implements DepartamentoWebClient {

  private final ApiProperties apiProperties;

  @Override
  public Mono<DepartamentoResponse> getAllDepartamento() {
    var response = WebClient.builder()
      .filter(errorHandler()).build().get()
      .uri(URI.create(apiProperties.getDptoUrl()))
      .header(HOST, apiProperties.getHost())
      .header(ORIGIN, apiProperties.getOrigin())
      .retrieve()
      .bodyToMono(String.class);

    return response.flatMap(rsp -> Mono.fromCallable(() -> new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .readValue(rsp, DepartamentoResponse.class)))
      .onErrorResume(ex -> Mono.error(ApiExceptionEnum.ERR001.buildException(ex)));
  }

  public static ExchangeFilterFunction errorHandler() {
    return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
      if (clientResponse.statusCode().is4xxClientError()) {
        return null;
      } else if (clientResponse.statusCode().is5xxServerError()) {
        return null;
      } else {
        return Mono.just(clientResponse);
      }
    });
  }
}
