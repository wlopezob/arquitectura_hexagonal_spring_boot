package com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.distrito;

import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.annotation.RestControllerAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.base.GenericController;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.distrito.DistritoRestController;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.dto.response.DistritoResponse;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.mappers.DistritoResponseMapper;
import com.edu.wlopezob.appcomisariav1.application.services.DistritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

import static com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.constants.APIConstants.API_DISTRITO;

@RestControllerAdapter
@RequestMapping(API_DISTRITO)
@RequiredArgsConstructor
public class DistritoRestControllerImpl extends GenericController implements DistritoRestController {

  private final DistritoService distritoService;
  private final DistritoResponseMapper mapper;

  @Override
  public Flux<DistritoResponse> getAll() {
    return distritoService.insertAllDistrito().map(mapper::toResponse);
  }
}
