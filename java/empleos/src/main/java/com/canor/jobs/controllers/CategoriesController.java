package com.canor.jobs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/categories")
// http://localhost:8080/categories/
public class CategoriesController {

  // @GetMapping("/index")
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  // http://localhost:8080/categories/index
  public String ShowIndex(Model model) {
    return "categories/listCategories";
  }

  @GetMapping("/create")
  // http://localhost:8080/categories/create
  public String Create() {
    return "categories/formCategory";
  }

  @PostMapping("/save")
  // http://localhost:8080/categories/save
  public String Save(
    @RequestParam("name") String name,
    @RequestParam("description") String description
  ) {
    System.out.println("Category: " + name);
    System.out.println("Description: " + description);

    // Una vez hecho el post, se redirige a esta vista.
    return "categories/listCategories";
  }
}
