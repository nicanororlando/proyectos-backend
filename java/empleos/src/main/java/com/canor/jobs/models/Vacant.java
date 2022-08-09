package com.canor.jobs.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Vacants")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vacant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Para generar la llave primaria.
  private Integer id;

  private String name;
  private String description;
  private Date date;
  private Double salary;
  private Boolean outstanding;
  private String image = "no-image.png";
  private String status;
  private String details;
  private Category category;

  // Cuando en la consola imprimamos un objeto de tipo 'vacant' se va a imprimir esto.
  @Override
  public String toString() {
    return (
      "Vacant [id=" +
      id +
      ", name=" +
      name +
      ", description=" +
      description +
      ", date=" +
      date +
      ", salary=" +
      salary +
      "]"
    );
  }
}
