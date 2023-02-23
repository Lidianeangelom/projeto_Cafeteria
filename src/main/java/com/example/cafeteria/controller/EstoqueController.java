package com.example.cafeteria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.cafeteria.repository.EstoqueRepository;

import jakarta.validation.Valid;

import com.example.cafeteria.model.Estoque;

@RestController
@RequestMapping("/estoque")
@CrossOrigin(origins="*",allowedHeaders="*")
public class EstoqueController {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@GetMapping
	public ResponseEntity <List<Estoque>> getAll(Long id){
		return ResponseEntity.ok(estoqueRepository.findAll());
	}
	
	@GetMapping ("/{id}") 
	public ResponseEntity <Estoque> getById(@PathVariable Long id){
		return estoqueRepository.findById(id)
				.map(resposta->ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Estoque> post(@Valid @RequestBody Estoque estoque) {
		return ResponseEntity.status(HttpStatus.CREATED).body(estoqueRepository.save(estoque));
	}

	@PutMapping
	public ResponseEntity<Estoque> put(@Valid @RequestBody Estoque estoque) {
		return estoqueRepository.findById(estoque.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(estoqueRepository.save(estoque)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		if (estoque.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		estoqueRepository.deleteById(id);
	}
	
	
	

}
