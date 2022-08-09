package com.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
  
  // http://localhost:8080/welcome
  @GetMapping("/welcome")
  public String showWelcome(Model model) {

    // Simulamos una consulta a la db.
    String userName = "Homero simpson";

    // A travez del objeto model, le enviamos a la vista el parametro 'name', con el valor 'userName'.
    model.addAttribute("name", userName);

    // Llamo al archivo index dentro de los 'templates'.
    return "index";
  }
  
  // http://localhost:8080/calculator
  @GetMapping("/calculator")
  public String showCalculator() {
    return "calculator";
  }

  // Usamos la misma ruta que en el template ya que ahi se envian los parametros en calculator.
  @GetMapping("/imc")
  // Los datos que recibo los recibe como cadena pero los va a transformar a este tipo de dato que yo defina.
  public String calculaIMC(double weight, double height, Model model) {
    double imc = weight / (height / height);
    model.addAttribute("imc", imc);

    return "result";
  } 
}
