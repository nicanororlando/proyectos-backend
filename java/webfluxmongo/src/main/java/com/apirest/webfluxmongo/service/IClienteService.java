package com.apirest.webfluxmongo.service;

import com.apirest.webfluxmongo.document.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClienteService {
  // FLUX y MONO son flujos de elementos. Ambos son observables y emiten elementos. Flux devuelve varios y mono solo 1.
  public Flux<Cliente> findAll();

  public Mono<Cliente> findById(String id);

  public Mono<Cliente> save(Cliente cliente);

  public Mono<Void> delete(Cliente cliente);
}
