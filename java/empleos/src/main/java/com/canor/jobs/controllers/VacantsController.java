package com.canor.jobs.controllers;

import com.canor.jobs.models.Vacant;
import com.canor.jobs.services.file.FileServiceImp;
import com.canor.jobs.services.file.IFileService;
import com.canor.jobs.services.vacant.IVacantService;
import com.canor.jobs.util.Utils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/vacants")
// http://localhost:8080/vacants/
public class VacantsController {

  @Autowired
  private IVacantService vacantService;

  @Autowired
  private IFileService fileService;

  @GetMapping("/")
  public String Index(Model model) {
    List<Vacant> vacants = vacantService.searchAll();
    model.addAttribute("vacants", vacants);
    return "vacants/index";
  }

  @GetMapping("/create")
  public String Create() {
    return "vacants/formVacant";
  }

  @PostMapping("/save")
  public String save(
    Vacant vacant,
    BindingResult result,
    @RequestParam("file") MultipartFile file,
    RedirectAttributes attributes
  )
    throws IOException {
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        System.out.println("Error: " + error.getDefaultMessage());
      }
      return "vacants/formVacant";
    }

    if (file == null || file.isEmpty()) {
      attributes.addFlashAttribute(
        "message",
        "Por favor seleccione un archivo"
      );
      return "redirect:/vacants/create";
    }

    StringBuilder builder = new StringBuilder();

    // Armamos paso por paso la ruta del archivo para cualquier sistema operativo. En nuestro caso quedaria:
    // C:\Users\nican\spring-upload-example\"nombre-del-archivo.ext"
    builder.append(System.getProperty("user.home"));
    // Con esto java va a traer el separador de carpetas correspondiente al sistema operativo que este ejecutando la app.
    builder.append(File.separator); // "/"
    builder.append("spring-upload-example");
    builder.append(File.separator); // "/"
    builder.append(file.getOriginalFilename());

    // Creamos el path pasandole la ruta de nuestro archivo.
    Path path = Paths.get(builder.toString());

    // Para obtener los bytes del archivo. Estos bytes los vamos a escribir en el archivo nuevo que vamos a subir.
    byte[] fileBytes = file.getBytes();

    // Le decimos en que archivo va a escribir nuestra aplicacion los bytes que leimos anteriormente.
    Files.write(path, fileBytes);

    vacant.setImage(file.getOriginalFilename());
    vacantService.save(vacant);

    attributes.addFlashAttribute(
      "message",
      "Archivo cargado correctamente: [" + builder.toString() + "]"
    );
    System.out.println("Vacant: " + vacant);

    return "redirect:/vacants/";
  }

  // @PostMapping("/save")
  // public String save(@RequestParam("files") List<MultipartFile> files) {
  //   try {
  //     fileService.save(files);
  //     return "vacants/index";
  //   } catch (Exception e) {
  //     return "redirect : vacants/formVacant";
  //   }
  // }

  // @PostMapping("/save")
  // // Cuando llegue el objeto vacant al controlador se agregara a nuestra lista.
  // public String Save(
  //   Vacant vacant,
  //   BindingResult result,
  //   RedirectAttributes attributes,
  //   @RequestParam("file") MultipartFile file
  // ) {
  //   if (result.hasErrors()) {
  //     for (ObjectError error : result.getAllErrors()) {
  //       System.out.println("Error: " + error.getDefaultMessage());
  //     }
  //     return "vacants/formVacant";
  //   }

  //   if (!file.isEmpty()) {
  //     String route =
  //       "H:/ProyectosBack/java/empleos/src/main/resources/static/images";
  //     String imageName = Utils.SaveFile(file, route);
  //     if (imageName != null) {
  //       vacant.setImage(imageName);
  //     }
  //   }

  //   vacantService.save(vacant);
  //   attributes.addFlashAttribute("msg", "Record Saved");
  //   System.out.println("Vacant: " + vacant);
  //   return "redirect: /vacants/index";
  // }

  // http://localhost:8080/vacants/delete?id=3
  @GetMapping("/delete")
  /* Cuando se realice una peticion get a esta url, en los parametros http se
   * buscara un parametro con el nombre 'id' y en caso de ser encontrado, se va a
   * vincular ese valor al parametro 'vacantId'.
   */
  public String Delete(@RequestParam("id") int vacantId, Model model) {
    System.out.println("Deleting vacant with id: " + vacantId);
    model.addAttribute("vacantId", vacantId);
    return "message";
  }

  // Al usar el parametro {id} indicamos que el parametro es dinamico.
  // http://localhost:8080/vacants/view/id
  @GetMapping("/view/{id}")
  /* Para vincular (binding) un parametro de una URL dinamica a un parametro en el
   * controlador, se utiliza la notacion 'PathVariable'. Con esta sintaxis Spring MVC
   * automaticamente extrae el valor del parametro y hara la conversion que nosotros
   * especifiquemos (en este caso la conversion es de tipo String a Int). Cabe
   * recalcar que el tipo que tiene que recibir debe ser si o si de tipo int en este caso.
   */
  public String SeeDetail(@PathVariable("id") int vacantId, Model model) {
    Vacant vacant = vacantService.findById(vacantId);
    model.addAttribute("vacant", vacant);
    model.addAttribute("vacantId", vacantId);

    return "vacants/detail";
  }

  // Esta anotacion permite crear un metodo para configurar el data binding.
  @InitBinder
  // Cuando haga un data binding con el tipo de dato 'Date' vamos a usar nuestro formato.
  public void initBinder(WebDataBinder webDataBinder) {
    /* Clase java estandar para dar formato a las fechas que van a venir de los 
    formularios. */
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    webDataBinder.registerCustomEditor(
      Date.class,
      new CustomDateEditor(dateFormat, false)
    );
  }
}
