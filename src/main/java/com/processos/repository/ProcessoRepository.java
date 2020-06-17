package com.processos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.processos.dominio.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Integer>{
	

	//@Transactional(readOnly = true)
	Processo findByNumeroProcesso(String numeroProcesso);

}
