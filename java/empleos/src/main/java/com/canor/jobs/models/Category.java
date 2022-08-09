package com.canor.jobs.models;

public class Category {

  private Integer Id;
  private String name;
  private String description;

  public Category(Integer Id, String name, String description) {
    this.Id = Id;
    this.name = name;
    this.description = description;
  }

  public Category() {}

  public void setId(Integer Id) {
    this.Id = Id;
  }

  public Integer getId() {
    return this.Id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
