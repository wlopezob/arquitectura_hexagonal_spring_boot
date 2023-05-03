package com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.provincia;

import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.annotation.RestControllerAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.base.GenericController;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.dto.response.ProvinciaResponse;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.mappers.ProvinciaResponseMapper;
import com.edu.wlopezob.appcomisariav1.application.services.ProvinciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

import static com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.constants.APIConstants.API_DEPARTAMENTO;
import static com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.constants.APIConstants.API_PROVINCIA;

@RestControllerAdapter
@RequestMapping(API_PROVINCIA)
@RequiredArgsConstructor
public class ProvinciaRestControllerImpl extends GenericController implements ProvinciaRestController{

  private final ProvinciaService provinciaService;
  private final ProvinciaResponseMapper mapper;

  @Override
  public Flux<ProvinciaResponse> getAll() {
    return provinciaService.insertAllProvincia().map(mapper::toResponse);
  }
}
