package com.edu.wlopezob.appcomisariav1.application.ports.out.distrito;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DistritoDeleteAllPort {
  Mono<Boolean> deleteAllDistrito();
}
