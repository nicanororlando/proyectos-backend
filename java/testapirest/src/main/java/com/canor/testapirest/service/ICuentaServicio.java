package com.canor.testapirest.service;

import com.canor.testapirest.entity.Cuenta;
import java.math.BigDecimal;
import java.util.List;

public interface ICuentaServicio {
  public List<Cuenta> listAll();

  public Cuenta findById(Long id);

  public Cuenta save(Cuenta cuenta);

  public int revisarTotalDeTransferencias(Long bancoId);

  public BigDecimal revisarSaldo(Long cuentaId);

  public void transferirDinero(
    Long numeroCuentaOrigen,
    Long numeroCuentaDestino,
    BigDecimal monto,
    Long bancoId
  );
}
