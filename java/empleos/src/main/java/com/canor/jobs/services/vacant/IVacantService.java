package com.canor.jobs.services.vacant;

import com.canor.jobs.models.Vacant;
import java.util.List;

public interface IVacantService {
  List<Vacant> searchAll();

  Vacant findById(Integer id);

  void save(Vacant vacant);
}
