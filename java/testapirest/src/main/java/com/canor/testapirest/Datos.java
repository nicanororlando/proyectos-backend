package com.canor.testapirest;

import com.canor.testapirest.entity.Banco;
import com.canor.testapirest.entity.Cuenta;
import java.math.BigDecimal;
import java.util.Optional;

public class Datos {

  public static Optional<Cuenta> crearCuenta001() {
    // Id: 1L (1 Long)
    return Optional.of(new Cuenta(1L, "Canor", new BigDecimal("1000")));
  }

  public static Optional<Cuenta> crearCuenta002() {
    // Id: 2L (2 Long)
    return Optional.of(new Cuenta(2L, "Julen", new BigDecimal("2000")));
  }

  public static Optional<Banco> crearBanco() {
    // Id: 1L (2 Long)
    return Optional.of(new Banco(1L, "El banco Financiero", 0));
  }
}
