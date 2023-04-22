package com.edu.wlopezob.appcomisariav1.application.ports.out.departamento;

import com.edu.wlopezob.appcomisariav1.dominio.departamento.Departamento;

import java.util.List;

@FunctionalInterface
public interface DepartamentoGetAllCallApiPort {
  List<Departamento> getAllDepartamento();
}
