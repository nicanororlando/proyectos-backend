package com.canor.testapirest.entity;

import com.canor.testapirest.exception.DineroInsuficienteException;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cuentas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String persona;
  private BigDecimal saldo;

  public void realizarDebito(BigDecimal monto) {
    BigDecimal nuevoSaldo = this.saldo.subtract(monto);
    if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
      throw new DineroInsuficienteException("Dinero Insuficiente en la cuenta");
    }
    this.saldo = nuevoSaldo;
  }

  public void realizarCredito(BigDecimal monto) {
    this.saldo = saldo.add(monto);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Cuenta)) {
      return false;
    }
    Cuenta cuenta = (Cuenta) o;
    return (
      Objects.equals(id, cuenta.id) &&
      Objects.equals(persona, cuenta.persona) &&
      Objects.equals(saldo, cuenta.saldo)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, persona, saldo);
  }
}
