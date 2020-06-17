package com.processos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.processos.dominio.ParteProcesso;

@Repository
public interface ParteProcessoRepository extends JpaRepository<ParteProcesso, Integer>{

}
