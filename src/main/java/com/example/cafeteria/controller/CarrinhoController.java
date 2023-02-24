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

import com.example.cafeteria.repository.CarrinhoRepository;

import jakarta.validation.Valid;

import com.example.cafeteria.model.Carrinho;

@RestController
@RequestMapping("/carrinho")
@CrossOrigin(origins="*",allowedHeaders="*")
public class CarrinhoController {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@GetMapping
	public ResponseEntity <List<Carrinho>> getAll(Long id){
		return ResponseEntity.ok(carrinhoRepository.findAll());
	}
	
	@GetMapping ("/{id}") 
	public ResponseEntity <Carrinho> getById(@PathVariable Long id){
		return carrinhoRepository.findById(id)
				.map(resposta->ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Carrinho> post(@Valid @RequestBody Carrinho carrinho) {
		return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoRepository.save(carrinho));
	}

	@PutMapping
	public ResponseEntity<Carrinho> put(@Valid @RequestBody Carrinho carrinho) {
		return carrinhoRepository.findById(carrinho.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(carrinhoRepository.save(carrinho)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Carrinho> carrinho = carrinhoRepository.findById(id);
		if (carrinho.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		carrinhoRepository.deleteById(id);
	}
	
	
	

}
