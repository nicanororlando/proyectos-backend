package com.canor.jobs.services.vacant;

import com.canor.jobs.models.Vacant;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VacantServiceImp implements IVacantService {

  private List<Vacant> list = null;

  public VacantServiceImp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    list = new LinkedList<Vacant>();
    try {
      Vacant vacant1 = new Vacant();
      vacant1.setId(1);
      vacant1.setName("Ingeniero civil");
      vacant1.setDescription(
        "Solicitamos Ingeniero civil para diseñar puente peatonal"
      );
      vacant1.setDate(sdf.parse("08-02-2019"));
      vacant1.setSalary(8500.0);
      vacant1.setOutstanding(true);
      vacant1.setImage("logo3.png");

      Vacant vacant2 = new Vacant();
      vacant2.setId(2);
      vacant2.setName("Ingeniero Electronico");
      vacant2.setDescription(
        "Solicitamos Ingeniero civil para diseñar puente peatonal"
      );
      vacant2.setDate(sdf.parse("08-02-2019"));
      vacant2.setSalary(16000.0);
      vacant2.setOutstanding(false);
      vacant2.setImage("logo4.png");

      Vacant vacant3 = new Vacant();
      vacant3.setId(3);
      vacant3.setName("Ingeniero Ambiental");
      vacant3.setDescription(
        "Solicitamos Ingeniero civil para diseñar puente peatonal"
      );
      vacant3.setDate(sdf.parse("08-02-2019"));
      vacant3.setSalary(3500.0);
      vacant3.setOutstanding(false);

      Vacant vacant4 = new Vacant();
      vacant4.setId(4);
      vacant4.setName("Ingeniero Agronomo");
      vacant4.setDescription(
        "Solicitamos Ingeniero civil para diseñar puente peatonal"
      );
      vacant4.setDate(sdf.parse("08-02-2019"));
      vacant4.setSalary(6900.0);
      vacant4.setOutstanding(true);
      vacant4.setImage("logo5.png");

      list.add(vacant1);
      list.add(vacant2);
      list.add(vacant3);
      list.add(vacant4);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  @Override
  public List<Vacant> searchAll() {
    return list;
  }

  @Override
  public Vacant findById(Integer vacantId) {
    for (Vacant v : list) {
      if (v.getId() == vacantId) {
        return v;
      }
    }
    return null;
  }

  @Override
  public void save(Vacant vacant) {
    list.add(vacant);
  }
}
