package com.processos.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.processos.dominio.Processo;
import com.processos.repository.ProcessoRepository;
import com.processos.service.ProcessoService;

@RestController
@RequestMapping(value="/processos")
public class ProcessoResource {
	
	@Autowired
	private ProcessoService repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity <List<Processo>> listar(){
		
		List<Processo> lista = repo.findAll();
		
		return ResponseEntity.ok().body(lista);
	}
	
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Processo>> find(@PathVariable Integer id) {
		Optional<Processo> cat = repo.find(id);
		return ResponseEntity.ok().body(cat);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert( @RequestBody Processo processo){
		
		Processo obj = repo.Inserir(processo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	

}
