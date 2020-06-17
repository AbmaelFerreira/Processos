package com.processos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.processos.dominio.ParteProcesso;
import com.processos.repository.ParteProcessoRepository;

@Service
public class ParteProcessoService {
	
	@Autowired
	private ParteProcessoRepository repo;
	
	public void Inserir(ParteProcesso parteProcesso) {
		repo.save(parteProcesso);
	}

}
