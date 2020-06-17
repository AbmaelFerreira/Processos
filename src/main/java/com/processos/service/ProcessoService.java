package com.processos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.processos.dominio.Processo;
import com.processos.repository.ProcessoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProcessoService {
	
	@Autowired
	private ProcessoRepository repo;
	
	public Processo Inserir(Processo processo) {
		return repo.save(processo);
	}
	
	public List<Processo> findAll(){
		return repo.findAll();
	}
	
	public Optional<Processo> find(Integer id) {
		Optional<Processo>  obj = repo.findById(id);
		if(obj == null) {
			
		}
		return obj ;
	}
	
}
