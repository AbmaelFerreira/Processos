package com.processos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.processos.dominio.Classe;
import com.processos.repository.ClasseRepository;

@Service
public class ClasseService {
	
	@Autowired
	private ClasseRepository repo;
	
	public void Inserir(Classe classe) {
		repo.save(classe);
	}

}
