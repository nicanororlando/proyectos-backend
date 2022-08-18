package com.canor.testapirest.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionDTO {

  private Long cuentaOrigenId;
  private Long cuentaDestinoId;
  private BigDecimal monto;
  private Long bancoId;
}
