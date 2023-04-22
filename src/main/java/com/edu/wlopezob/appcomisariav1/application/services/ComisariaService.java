package com.edu.wlopezob.appcomisariav1.application.services;

import com.edu.wlopezob.appcomisariav1.application.ports.in.comisaria.ComisariaGetAllUseCase;
import com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria.ComisariaCountCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria.ComisariaDeleteAllPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria.ComisariaGetAllCallApiPort;
import com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria.ComisariaInsertAllPort;
import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class ComisariaService implements ComisariaGetAllUseCase {
  private final ComisariaCountCallApiPort comisariaCountCallApiPort;
  private final ComisariaDeleteAllPort comisariaDeleteAllPort;
  private final ComisariaGetAllCallApiPort comisariaGetAllCallApiPort;
  private final ComisariaInsertAllPort comisariaInsertAllPort;

  @Override
  public List<Comisaria> getAllComisaria() {
    // delete all db
    comisariaDeleteAllPort.deleteAllComisaria();

    return Optional.of(comisariaCountCallApiPort.getCountComisaria())
      .map(comisariaGetAllCallApiPort::getAllComisaria)
      .map(comisariaInsertAllPort::insertAllComisaria).orElse(null);
  }
}
