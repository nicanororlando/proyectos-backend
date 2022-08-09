package com.sp.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sp.mongodb.models.ToDoDTO;

@Repository
// En el extend de mongo primero va el modelo y segundo el tipo de llave primaria.
public interface ToDoRepository extends MongoRepository<ToDoDTO, String> {
  
  @Query("{'todo': ?0}")
  Optional<ToDoDTO> findByToDo(String todo);
}
