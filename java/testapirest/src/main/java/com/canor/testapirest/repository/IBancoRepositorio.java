package com.canor.testapirest.repository;

import com.canor.testapirest.entity.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBancoRepositorio extends JpaRepository<Banco, Long> {}
