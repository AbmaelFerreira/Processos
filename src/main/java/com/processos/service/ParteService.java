package com.processos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.processos.dominio.Parte;
import com.processos.repository.ParteRepository;

@Service
public class ParteService {
	
	@Autowired
	private ParteRepository repo;
	
	public void Inserir(Parte parte) {
		repo.save(parte);
	}

}
