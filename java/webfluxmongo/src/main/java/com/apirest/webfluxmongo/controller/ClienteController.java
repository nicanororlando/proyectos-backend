package com.apirest.webfluxmongo.controller;

import com.apirest.webfluxmongo.document.Cliente;
import com.apirest.webfluxmongo.service.IClienteService;
import java.io.File;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
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
      // Para transferir un archivo al almacenamiento nuestro.
      .transferTo(new File(path + cliente.getFoto()))
      // Guardamos el cliente en la base de datos.
      .then(service.save(cliente))
      // Con map, realizamos una transformacion, y devolvemos un ResponseEntity con el URI nuevo.
      .map(
        c ->
          ResponseEntity
            .created(URI.create("/api/clientes/".concat(c.getId())))
            .contentType(MediaType.APPLICATION_JSON)
            // Le enviamos el cuerpo.
            .body(c)
      );
  }

  @PostMapping("/upload/{id}")
  // Retornamos un flujo Mono, que es un Cliente con su foto.
  public Mono<ResponseEntity<Cliente>> subirFoto(
    @PathVariable String id,
    @RequestPart FilePart file
  ) {
    return service
      // Primero buscamos y retornamos el cliente:
      .findById(id)
      // A diferencia de map, este va a transformar una entrada en varias salidas.
      .flatMap(
        c -> {
          // Al objeto cliente 'c' le establedemos una foto.
          c.setFoto(
            UUID.randomUUID().toString() +
            "-" +
            file.filename().replace(" ", "").replace(":", "").replace("//", "")
          );

          // Esa foto que seteamos la retornamos:
          return file
            // La guardamos en nuestra carpeta predefinida:
            .transferTo(new File(path + c.getFoto()))
            // Guardamos en nuestra base de datos tambien:
            .then(service.save(c));
        }
      ) // Transformamos nuestro retorno:
      .map(cl -> ResponseEntity.ok(cl))
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @GetMapping
  /* Retorna mono, por que voy a devolver un solo ResponseEntity, pero esta respuesta va a retornar
   * un flujo de clientes. Entonces este metodo nos va a 'emitir' los clientes.
   * Esta respuesta va a tener un flujo 'Mono' y este flujo me va a emitir los Clientes.
   */
  public Mono<ResponseEntity<Flux<Cliente>>> listarClientes() {
    /* Esta respuesta va a retornar un flujo de clientes. just sirve para darle valores a este flujo. */
    return Mono.just(
      ResponseEntity
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        // Aca me subscribo al flujo y listo los clientes.
        .body(service.findAll())
    );
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<Cliente>> verDetallesDelCliente(
    @PathVariable String id
  ) {
    return service
      // Nos subscribimos al flujo
      .findById(id)
      .map(
        // Realizamos la transformacion. Si todo esta bien retorna codigo 200 y el cuerpo.
        c -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(c)
      )
      // Si no sale bien retorna 404.
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Mono<ResponseEntity<Map<String, Object>>> guardarCliente(
    // Emitimos el cliente
    @Valid @RequestBody Mono<Cliente> monoCliente
  ) {
    Map<String, Object> respuesta = new HashMap<>();
    return monoCliente
      .flatMap(
        cliente -> {
          return service
            // Creamos el flujo
            .save(cliente)
            // Transformamos el flujo, creando un mapa y retornando otra salida de tipo ResponseEntity.
            .map(
              c -> {
                respuesta.put("cliente", c);
                respuesta.put("mensaje", "Cliente guardado con exito");
                respuesta.put("timestamp", new Date());
                return ResponseEntity
                  .created(URI.create("/api/clientes/".concat(c.getId())))
                  .contentType(MediaType.APPLICATION_JSON)
                  .body(respuesta);
              }
            );
        }
      )
      .onErrorResume(
        t -> {
          // Llenamos el flujo de Mono con el error.
          return Mono
            .just(t)
            .cast(WebExchangeBindException.class)
            // Obtenemos los errores:
            .flatMap(e -> Mono.just(e.getFieldErrors()))
            .flatMapMany(Flux::fromIterable)
            .map(
              fieldError ->
                "El campo : " +
                fieldError.getField() +
                " " +
                fieldError.getDefaultMessage()
            )
            .collectList()
            .flatMap(
              list -> {
                respuesta.put("errors", list);
                respuesta.put("timestamp", new Date());
                respuesta.put("status", HttpStatus.BAD_REQUEST.value());

                return Mono.just(ResponseEntity.badRequest().body(respuesta));
              }
            );
        }
      );
  }

  @PutMapping("/{id}")
  public Mono<ResponseEntity<Cliente>> editarCliente(
    @RequestBody Cliente cliente,
    @PathVariable String id
  ) {
    return service
      .findById(id)
      .flatMap(
        c -> {
          c.setNombre(cliente.getNombre());
          c.setApellido(cliente.getApellido());
          c.setEdad(cliente.getEdad());
          c.setSueldo(cliente.getSueldo());

          return service.save(c);
        }
      )
      .map(
        c ->
          ResponseEntity
            .created(URI.create("/api/clientes/".concat(c.getId())))
            .contentType(MediaType.APPLICATION_JSON)
            .body(c)
      )
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> eliminarCliente(@PathVariable String id) {
    return service
      .findById(id)
      // Este flatMap va a devolver el cliente eliminado y a parte un flujo de elemento con los codigos de estado.
      .flatMap(
        c -> {
          return service
            .delete(c)
            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }
      )
      .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
  }
}
