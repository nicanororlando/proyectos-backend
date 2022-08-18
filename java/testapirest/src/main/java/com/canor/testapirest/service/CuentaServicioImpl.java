package com.canor.testapirest.service;

import com.canor.testapirest.entity.Banco;
import com.canor.testapirest.entity.Cuenta;
import com.canor.testapirest.repository.IBancoRepositorio;
import com.canor.testapirest.repository.ICuentaRepositorio;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuentaServicioImpl implements ICuentaServicio {

  @Autowired
  private ICuentaRepositorio cuentaRepositorio;

  @Autowired
  private IBancoRepositorio bancoRepositorio;

  @Override
  // Para indicar que este metodo se ejecute en la misma transaccion y que sea de solo lectura (listar datos)
  @Transactional(readOnly = true)
  public List<Cuenta> listAll() {
    return cuentaRepositorio.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Cuenta findById(Long id) {
    return cuentaRepositorio.findById(id).orElseThrow();
  }

  @Override
  @Transactional
  public Cuenta save(Cuenta cuenta) {
    return cuentaRepositorio.save(cuenta);
  }

  @Override
  @Transactional(readOnly = true)
  public int revisarTotalDeTransferencias(Long bancoId) {
    Banco banco = bancoRepositorio.findById(bancoId).orElseThrow();
    return banco.getTotalTransferencias();
  }

  @Override
  @Transactional(readOnly = true)
  public BigDecimal revisarSaldo(Long cuentaId) {
    Cuenta cuenta = cuentaRepositorio.findById(cuentaId).orElseThrow();
    return cuenta.getSaldo();
  }

  @Override
  public void transferirDinero(
    Long numeroCuentaOrigen,
    Long numeroCuentaDestino,
    BigDecimal monto,
    Long bancoId
  ) {
    // Quitamos el dinero de la cuenta de origen y guardamos.
    Cuenta cuentaOrigen = cuentaRepositorio
      .findById(numeroCuentaOrigen)
      .orElseThrow();
    cuentaOrigen.realizarDebito(monto);
    cuentaRepositorio.save(cuentaOrigen);

    // Añadimos el dinero a la cuenta de destino y guardamos.
    Cuenta cuentaDestino = cuentaRepositorio
      .findById(numeroCuentaDestino)
      .orElseThrow();
    cuentaDestino.realizarCredito(monto);
    cuentaRepositorio.save(cuentaDestino);

    Banco banco = bancoRepositorio.findById(bancoId).orElseThrow();
    int totalTransferencias = banco.getTotalTransferencias();
    banco.setTotalTransferencias(++totalTransferencias);
    bancoRepositorio.save(banco);
  }
}
