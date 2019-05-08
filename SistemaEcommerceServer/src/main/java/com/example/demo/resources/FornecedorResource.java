	package com.example.demo.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Fornecedor;
import com.example.demo.repositories.FornecedorRepository;

@RestController
@RequestMapping(value="/fornecedores")
@CrossOrigin(origins = "http://localhost:4200")
public class FornecedorResource {
	
	@Autowired
	private FornecedorRepository service;
	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAll() {
		List<Fornecedor> fornecedores = service.findAll();
		return ResponseEntity.ok().body(fornecedores);
	}
		
	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Fornecedor fornecedor) {
		service.save(fornecedor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(fornecedor.getCodigo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<?> atualizar(@Valid @RequestBody Fornecedor fornecedor) {
		service.save(fornecedor);
	    return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="{codigo}")
	public ResponseEntity<?> excluir(@PathVariable Integer codigo) {
		try {
			service.deleteById(codigo);
			return ResponseEntity.ok(codigo);	
		} catch(EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Optional<Fornecedor> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}