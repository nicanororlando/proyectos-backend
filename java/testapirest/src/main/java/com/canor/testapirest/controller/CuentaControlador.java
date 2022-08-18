package com.canor.testapirest.controller;

import com.canor.testapirest.entity.Cuenta;
import com.canor.testapirest.entity.TransaccionDTO;
import com.canor.testapirest.service.ICuentaServicio;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// Esta notacion incluye @Controller y @ResponseBody, por lo que cada metodo va a devolver un JSON.
@RestController
@RequestMapping("/api/cuentas")
public class CuentaControlador {

  @Autowired
  private ICuentaServicio cuentaServicio;

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public List<Cuenta> listarCuentas() {
    return cuentaServicio.listAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public Cuenta verDetalles(@PathVariable Long id) {
    return cuentaServicio.findById(id);
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Cuenta guardarCuenta(@RequestBody Cuenta cuenta) {
    return cuentaServicio.save(cuenta);
  }

  @PostMapping("/transferir")
  public ResponseEntity<?> transferirDinero(
    @RequestBody TransaccionDTO transaccionDTO
  ) {
    cuentaServicio.transferirDinero(
      transaccionDTO.getCuentaOrigenId(),
      transaccionDTO.getCuentaDestinoId(),
      transaccionDTO.getMonto(),
      transaccionDTO.getBancoId()
    );

    // Creamos una estructura de datos 'respuesta' para almacenar pares "key/value".
    Map<String, Object> respuesta = new HashMap<>();
    respuesta.put("date", LocalDate.now());
    respuesta.put("status", "OK");
    respuesta.put("mensaje", "Transferencia realizada con exitoo");
    respuesta.put("transaccionDTO", transaccionDTO);

    return ResponseEntity.ok(respuesta);
  }
}
