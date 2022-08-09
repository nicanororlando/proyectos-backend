package com.canor.jobs;

import com.canor.jobs.models.Category;
import com.canor.jobs.models.Vacant;
import com.canor.jobs.repository.IVacantsRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobsApplication {

  @Autowired
  private IVacantsRepository vacantsRepository;

  public static void main(String[] args) {
    SpringApplication.run(JobsApplication.class, args);
  }

  public void run(String... args) throws Exception {
    saveVacant();
  }

  private void saveVacant() {
    Vacant vacant = new Vacant();
    vacant.setName("Profesor de matematicas");
    vacant.setDescription(
      "Escuela secundaria solicita profesor para curso de matematicas"
    );
    vacant.setDate(new Date());
    vacant.setSalary(1000.0);
    vacant.setStatus("Aproved");
    vacant.setOutstanding(false);
    vacant.setImage("escuela.png");
    vacant.setDescription(
      "<h1>Los requisitos para profesor de matematicas</h2>"
    );

    Category cat = new Category();
    cat.setId(15);
    vacant.setCategory(cat);

    vacantsRepository.save(vacant);
  }
}
