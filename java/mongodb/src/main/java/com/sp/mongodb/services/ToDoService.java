package com.sp.mongodb.services;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.sp.mongodb.exceptions.ToDoCollectionException;
import com.sp.mongodb.models.ToDoDTO;

public interface ToDoService {
  public void createToDo(ToDoDTO todo) throws ConstraintViolationException, ToDoCollectionException;
  
  public List<ToDoDTO> getAllToDos();

  public ToDoDTO getSingleToDo(String id) throws ToDoCollectionException;

  public void updateToDo(String id, ToDoDTO todo) throws ConstraintViolationException, ToDoCollectionException;

  public void deleteToDo(String id) throws ToDoCollectionException;
}