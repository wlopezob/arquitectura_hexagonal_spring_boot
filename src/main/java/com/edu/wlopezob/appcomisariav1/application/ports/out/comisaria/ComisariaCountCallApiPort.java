package com.edu.wlopezob.appcomisariav1.application.ports.out.comisaria;

import com.edu.wlopezob.appcomisariav1.dominio.Comisaria.Comisaria;

import java.util.List;

@FunctionalInterface
public interface ComisariaCountCallApiPort {
  int getCountComisaria();
}
