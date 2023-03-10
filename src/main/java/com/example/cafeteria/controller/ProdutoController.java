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

import com.example.cafeteria.model.Produto;
import com.example.cafeteria.repository.ProdutoRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/produto")
@CrossOrigin(origins="*",allowedHeaders="*")
public class ProdutoController {
	@Autowired ProdutoRepository produtoRepository;
	
	@GetMapping ("/all")
	public ResponseEntity <List<Produto>> getAllProduto(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping ("/{id}") 
	public ResponseEntity <Produto> getById(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resposta->ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/nome/{usuario}") 
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(produtoRepository.findByNome(nome));
		
	}
	
	@GetMapping("/tipo/{tipo}") 
	public ResponseEntity<List<Produto>> getByTipo(@PathVariable String tipo) {
		return ResponseEntity.ok(produtoRepository.findByNome(tipo));
		
	}
	
	@GetMapping("/categoria/{categoria}") 
	public ResponseEntity<List<Produto>> getByCategoria(@PathVariable String categoria) {
		return ResponseEntity.ok(produtoRepository.findByNome(categoria));
		
	}
	
	@GetMapping("/preco/{preco}") //testar//
	public ResponseEntity<Object> getByPreco(@PathVariable Float preco) {
		return ResponseEntity.ok(produtoRepository.findByPreco(preco));
		
	}
	
	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtoRepository.save(produto));
	}

	@PutMapping
	public ResponseEntity<Produto> put (@Valid @RequestBody Produto produto){
		return produtoRepository.findById(produto.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
				.body(produtoRepository.save(produto)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		Optional <Produto> produto = produtoRepository.findById(id);
		
		if(produto.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		produtoRepository.deleteById(id);
				
	}
}



