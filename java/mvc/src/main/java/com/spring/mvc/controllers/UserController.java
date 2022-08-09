package com.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.mvc.daos.UserDAO;
import com.spring.mvc.daos.UserDAOJDBC;
import com.spring.mvc.entities.User;

@Controller
public class UserController {

  // Clase auxiliar para hacer la consulta
  @Autowired
  @Qualifier("user-dao-jpa")
  private UserDAO userDAO = new UserDAOJDBC();
  
  //http://localhost:8080/user?id=1 
  @GetMapping("user")
  public String showInfo(int id, Model model) {
    
    // Consulta a la db
    System.out.println("Obteniendo informacion del usuario con id: " + id);
    User userFound = userDAO.getUserById(id);
    model.addAttribute("user", userFound);

    return "info-user"; 
  }
}
