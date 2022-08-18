package com.test.crudtest;

import org.springframework.data.repository.CrudRepository;

public interface IProductoRepositorio
  extends CrudRepository<Producto, Integer> {
  public Producto findByNombre(String nombre);
}
