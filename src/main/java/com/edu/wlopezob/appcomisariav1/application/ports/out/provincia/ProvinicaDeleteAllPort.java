package com.edu.wlopezob.appcomisariav1.application.ports.out.provincia;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ProvinicaDeleteAllPort {
  Mono<Void> deleteAllProvincia();
}
