package com.sp.mongodb.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.mongodb.exceptions.ToDoCollectionException;
import com.sp.mongodb.models.ToDoDTO;
import com.sp.mongodb.repository.ToDoRepository;

@Service
public class ToDoServiceImplement implements ToDoService {

  @Autowired
  private ToDoRepository toDoRepository;

  @Override
  public void createToDo(ToDoDTO todo) throws ConstraintViolationException, ToDoCollectionException {
    Optional<ToDoDTO> toDoOptional = toDoRepository.findByToDo(todo.getTodo());
    if (toDoOptional.isPresent()) {
      throw new ToDoCollectionException(ToDoCollectionException.ToDoAlreadyExists());
    } else {
      todo.setCreatedAt(new Date(System.currentTimeMillis()));
      toDoRepository.save(todo);
    }
  }

  @Override
  public List<ToDoDTO> getAllToDos() {
    List<ToDoDTO> todos = toDoRepository.findAll();
    if (todos.size() > 0) {
      return todos;
    } else {
      return new ArrayList<ToDoDTO>();
    }
  }

  @Override
  public ToDoDTO getSingleToDo(String id) throws ToDoCollectionException {
    Optional<ToDoDTO> optionalToDo = toDoRepository.findById(id);
    if (optionalToDo.isPresent()) {
      return optionalToDo.get();
    } else {
      throw new ToDoCollectionException(ToDoCollectionException.NotFoundException(id));
    }
  }

  @Override
  public void updateToDo(String id, ToDoDTO todo) throws ConstraintViolationException, ToDoCollectionException {
    Optional<ToDoDTO> optionalToDo = toDoRepository.findById(id);
    Optional<ToDoDTO> todoRepo = toDoRepository.findByToDo(todo.getTodo());
    if (optionalToDo.isPresent()) {

      if (todoRepo.isPresent() && !todoRepo.get().getId().equals(id)) {
        throw new ToDoCollectionException(ToDoCollectionException.ToDoAlreadyExists());
      }
      
      ToDoDTO todoToSave = optionalToDo.get();

      todoToSave.setTodo(todo.getTodo() != null ? todo.getTodo() : todoToSave.getTodo());
      todoToSave.setDescription(todo.getDescription() != null ? todo.getDescription() : todoToSave.getDescription());
      todoToSave.setCompleted(todo.getCompleted() != null ? todo.getCompleted() : todoToSave.getCompleted());
      todoToSave.setUpdatedAt(new Date(System.currentTimeMillis()));

      toDoRepository.save(todoToSave);
    } else {
      throw new ToDoCollectionException(ToDoCollectionException.NotFoundException(id));
    }
  }

  @Override
  public void deleteToDo(String id) throws ToDoCollectionException {
    Optional<ToDoDTO> optionalToDo = toDoRepository.findById(id);
    if (optionalToDo.isEmpty()) {
      throw new ToDoCollectionException(ToDoCollectionException.NotFoundException(id));
    } else {
      toDoRepository.deleteById(id);
    }
  }
}
