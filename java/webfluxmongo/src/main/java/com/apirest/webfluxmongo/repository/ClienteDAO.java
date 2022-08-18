package com.apirest.webfluxmongo.repository;

import com.apirest.webfluxmongo.document.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClienteDAO extends ReactiveMongoRepository<Cliente, String> {}
