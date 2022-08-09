package com.canor.jobs.repository;

import com.canor.jobs.models.Vacant;
import org.springframework.data.jpa.repository.JpaRepository;

// El primer param es el tipo de entidad del repositorio y el segundo param es el tipo de la llave primaria.
public interface IVacantsRepository extends JpaRepository<Vacant, Integer> {}
