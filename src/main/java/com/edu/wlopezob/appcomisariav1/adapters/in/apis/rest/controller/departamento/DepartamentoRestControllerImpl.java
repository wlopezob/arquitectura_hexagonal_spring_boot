package com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.departamento;

import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.annotation.RestControllerAdapter;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.base.GenericController;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.dto.response.DepartamentoResponse;
import com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.mappers.DepartamentoResponseMapper;
import com.edu.wlopezob.appcomisariav1.application.services.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

import static com.edu.wlopezob.appcomisariav1.adapters.in.apis.rest.controller.constants.APIConstants.*;

@RestControllerAdapter
@RequestMapping(API_DEPARTAMENTO)
@RequiredArgsConstructor
public class DepartamentoRestControllerImpl extends GenericController implements DepartamentoRestController {

  private final DepartamentoService departamentoService;
  private final DepartamentoResponseMapper mapper;

  @Override
  public Flux<DepartamentoResponse> getAll() {
    return departamentoService.insertAllDepartamento()
      .map(mapper::toResponse);
  }
}
