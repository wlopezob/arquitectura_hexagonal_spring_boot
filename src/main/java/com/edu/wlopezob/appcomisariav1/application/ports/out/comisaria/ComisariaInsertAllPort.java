package com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria;

import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;
import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;

import java.util.List;

@FunctionalInterface
public interface ComisariaInsertAllPort {
  List<Comisaria> insertAllComisaria(List<Comisaria> comisarias);
}
