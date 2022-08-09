package com.canor.jobs.controllers;

import com.canor.jobs.models.Vacant;
import com.canor.jobs.services.vacant.IVacantService;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  /* Spring va a buscar en el contenedor de 'Beans' una instancia del tipo de la
   * interfaz. Al encontrarla la va a inyectar en nuestra variable vacantService.
   */
  @Autowired
  private IVacantService vacantService;

  @GetMapping("/")
  public String Home(Model model) {
    List<Vacant> list = vacantService.searchAll();
    model.addAttribute("vacants", list);

    return "home";
  }

  @GetMapping("/table")
  public String ShowTableModel(Model model) {
    List<Vacant> list = vacantService.searchAll();
    model.addAttribute("vacants", list);

    return "table";
  }

  @GetMapping("/list")
  public String ShowList(Model model) {
    List<String> list = new LinkedList<String>();
    list.add("System engineer");
    list.add("Accounting clerk");
    list.add("Seller");
    list.add("Architect");

    model.addAttribute("jobs", list);
    return "list";
  }

  @GetMapping("/detail")
  public String ShowDetail(Model model) {
    Vacant vacant = new Vacant();
    vacant.setName("Communication engineer");
    vacant.setDescription("Engineer required to support internet");
    vacant.setDate(new Date());
    vacant.setSalary(9700.0);

    model.addAttribute("vacant", vacant);
    return "detail";
  }
}
