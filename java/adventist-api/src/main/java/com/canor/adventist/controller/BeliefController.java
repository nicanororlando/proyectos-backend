package com.canor.adventist.controller;

import com.canor.adventist.exceptions.Exceptions;
import com.canor.adventist.model.Belief;
import com.canor.adventist.service.Belief.BeliefService;
import java.util.List;
import javax.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// Hay distintas formas de manejar los errores, para probar.

@RestController
@RequestMapping("/api/beliefs")
@RequiredArgsConstructor
public class BeliefController {

  private final BeliefService beliefService;

  @GetMapping("")
  public ResponseEntity<List<Belief>> findAll() {
    List<Belief> beliefs = beliefService.findAll();
    return ResponseEntity
      .status(beliefs.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND)
      .body(beliefs);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Integer id) {
    try {
      return ResponseEntity
        .status(HttpStatus.OK)
        .body(beliefService.findById(id).get());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PostMapping("")
  public ResponseEntity<?> save(@RequestBody Belief belief) {
    try {
      beliefService.save(belief);
      return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(beliefService.findById(belief.getId()));
    } catch (ConstraintViolationException e) {
      return ResponseEntity
        .status(HttpStatus.UNPROCESSABLE_ENTITY)
        .body(e.getMessage());
    } catch (Exceptions e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
  }

  @PostMapping("/file/{id}")
  public ResponseEntity<?> uploadFile(
    @PathVariable Integer id,
    @RequestPart MultipartFile file
  )
    throws Exception {
    try {
      beliefService.saveFile(id, file);
      return ResponseEntity
        .status(HttpStatus.CREATED)
        .body("\"image\"" + ": " + beliefService.findById(id).get().getImage());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  // Le indico que va a tener una extension.
  @GetMapping("/file/{filename:.+}")
  @ResponseStatus(code = HttpStatus.NOT_MODIFIED)
  public ResponseEntity<Resource> getImage(@PathVariable String filename)
    throws Exception {
    Resource resource = (Resource) beliefService.uri(filename);
    return ResponseEntity
      .ok()
      .contentType(MediaType.IMAGE_PNG)
      .contentType(MediaType.IMAGE_JPEG)
      .contentType(MediaType.IMAGE_GIF)
      .body(resource);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
    @PathVariable("id") Integer id,
    @RequestBody Belief belief
  ) {
    try {
      beliefService.update(id, belief);
      return ResponseEntity
        .status(HttpStatus.OK)
        .body(beliefService.findById(id));
    } catch (Exceptions e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (ConstraintViolationException e) {
      return ResponseEntity
        .status(HttpStatus.UNPROCESSABLE_ENTITY)
        .body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable Integer id) {
    try {
      beliefService.deleteById(id);
      return ResponseEntity
        .status(HttpStatus.OK)
        .body("Succesfully deleted by id " + id);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }
}
// // Para descargar archivos:
// ResponseEntity
//       .ok()
// .header(
//   HttpHeaders.CONTENT_DISPOSITION,
//   "attachment; filename=\"" + resource.getFilename() + "\""
// )
// .body(resource);