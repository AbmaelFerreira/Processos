package com.processos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.processos.dominio.Parte;

@Repository
public interface ParteRepository extends JpaRepository<Parte, Integer>{

}
