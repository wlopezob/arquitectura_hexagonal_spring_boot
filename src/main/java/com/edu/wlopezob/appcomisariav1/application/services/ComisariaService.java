package com.edu.wlopezob.appcomisariav1.application.services;

import com.edu.wlopezob.appcomisariav1.application.ports.in.comisaria.ComisariaGetAllUseCase;
import com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria.ComisariaCountCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria.ComisariaDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria.ComisariaGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria.ComisariaInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class ComisariaService implements ComisariaGetAllUseCase {
  private final ComisariaCountCallApiPort comisariaCountCallApiPort;
  private final ComisariaDeleteAllPort comisariaDeleteAllPort;
  private final ComisariaGetAllCallApiPort comisariaGetAllCallApiPort;
  private final ComisariaInsertAllPort comisariaInsertAllPort;

  @Override
  public Flux<Comisaria> getAllComisaria() {
    return comisariaDeleteAllPort.deleteAllComisaria().flux()
      .flatMap(b -> comisariaCountCallApiPort.getCountComisaria()
        .flatMap(count -> comisariaGetAllCallApiPort.getAllComisaria(count)))
      .flatMap(comisarias -> comisariaInsertAllPort.insertAllComisaria(comisarias));
  }
}
