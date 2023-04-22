package com.edu.wlopezob.appcomisariav1.application.ports.in.comisaria;

import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;

import java.util.List;

@FunctionalInterface
public interface ComisariaGetAllUseCase {
  List<Comisaria> getAllComisaria();
}
