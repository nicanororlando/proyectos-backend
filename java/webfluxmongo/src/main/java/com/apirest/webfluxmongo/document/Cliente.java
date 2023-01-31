package com.apirest.webfluxmongo.document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

  @Id
  private String id;

  @NotEmpty
  private String nombre;

  @NotEmpty
  private String apellido;

  @NotNull
  private Integer edad;

  @NotNull
  private Double sueldo;

  private String foto;
}
