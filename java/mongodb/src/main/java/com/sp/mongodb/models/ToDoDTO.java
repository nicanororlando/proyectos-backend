package com.sp.mongodb.models;

import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todos") // Para trabajar con bases de datos.
public class ToDoDTO {

  @Id
  private String id;

  @NotNull(message = "Todo cannot be null")
  private String todo;

  @NotNull(message = "Description cannot be null")
  private String description;

  @NotNull(message = "Completed cannot be null")
  private Boolean completed;

  private Date createdAt;
  private Date updatedAt;
}
