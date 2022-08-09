package com.sp.mongodb.controllers;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sp.mongodb.exceptions.ToDoCollectionException;
import com.sp.mongodb.models.ToDoDTO;
import com.sp.mongodb.services.ToDoService;

@Controller
public class ToDoController {

  @Autowired
  private ToDoService toDoService;

  // Creamos un Rest Endpoint que retorna la lista de 
  @GetMapping("/todos")
  public ResponseEntity<?> getAllToDos() {
    List<ToDoDTO> todos = toDoService.getAllToDos();
    return new ResponseEntity<>(todos, todos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
  }

  @GetMapping("/todos/{id}")
  public ResponseEntity<?> getToDoById(@PathVariable("id") String id) {
    try {
      return new ResponseEntity<>(toDoService.getSingleToDo(id), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); 
    }
  }
 
  @PostMapping("/todos")
  public ResponseEntity<?> createToDo(@RequestBody ToDoDTO todo) {
    try {
      toDoService.createToDo(todo);
      return new ResponseEntity<ToDoDTO>(todo, HttpStatus.OK);
    } catch (ConstraintViolationException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    } catch (ToDoCollectionException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
  }

  @PutMapping("/todos/{id}")
  public ResponseEntity<?> updateToDoById(@PathVariable("id") String id, @RequestBody ToDoDTO todo) {
    try {
      toDoService.updateToDo(id, todo);
      return new ResponseEntity<ToDoDTO>(toDoService.getSingleToDo(id), HttpStatus.OK);
    } catch (ToDoCollectionException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    } catch (ConstraintViolationException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }
  
  @DeleteMapping("/todos/{id}")
  public ResponseEntity<?> deleteToDoById(@PathVariable("id") String id) {
    try {
      toDoService.deleteToDo(id);
      return new ResponseEntity<>("Succesfully deleted by id " + id, HttpStatus.OK);
    } catch (ToDoCollectionException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
}
