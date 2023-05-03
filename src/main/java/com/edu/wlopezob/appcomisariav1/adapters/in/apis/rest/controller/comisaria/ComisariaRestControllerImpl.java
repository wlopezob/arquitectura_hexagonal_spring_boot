package com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.comisaria;

import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.annotation.RestControllerAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.base.GenericController;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.dto.response.ComisariaResponse;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.mappers.ComisariaResponseMapper;
import com.edu.wlopezob.appcomisariav1.application.services.ComisariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

import static com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.constants.APIConstants.API_COMISARIA;

@RestControllerAdapter
@RequestMapping(API_COMISARIA)
@RequiredArgsConstructor
public class ComisariaRestControllerImpl extends GenericController implements ComisariaRestController {

  private final ComisariaService distritoService;
  private final ComisariaResponseMapper mapper;

  @Override
  public Flux<ComisariaResponse> getAll() {
    return distritoService.getAllComisaria().map(mapper::toResponse);
  }
}
