package com.apirest.webfluxmongo.controller;

import com.apirest.webfluxmongo.document.Cliente;
import com.apirest.webfluxmongo.service.IClienteService;
import java.io.File;
import java.net.URI;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

  @Autowired
  private IClienteService service;

  // Ruta para guardar imagenes.
  @Value("${config.uploads.path}")
  private String path;

  @PostMapping("/registrarClienteConFoto")
  public Mono<ResponseEntity<Cliente>> registrarClienteConFoto(
    Cliente cliente,
    @RequestPart FilePart file
  ) {
    cliente.setFoto(
      UUID.randomUUID().toString() +
      "-" +
      file.filename().replace(" ", "").replace(":", "").replace("//", "")
    );
    return file
      // Para transferir un archivo
      .transferTo(new File(path + cliente.getFoto()))
      .then(service.save(cliente))
      // Para convertir
      .map(
        c ->
          ResponseEntity
            .created(URI.create("/api/clientes".concat(c.getId())))
            .contentType(MediaType.APPLICATION_JSON)
            .body(c)
      );
  }
}
