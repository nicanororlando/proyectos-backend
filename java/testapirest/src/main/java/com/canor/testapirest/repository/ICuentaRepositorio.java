package com.canor.testapirest.repository;

import com.canor.testapirest.entity.Cuenta;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICuentaRepositorio extends JpaRepository<Cuenta, Long> {
  @Query("select c from Cuenta c where c.persona=?1")
  public Optional<Cuenta> findByPersona(String persona);
}
