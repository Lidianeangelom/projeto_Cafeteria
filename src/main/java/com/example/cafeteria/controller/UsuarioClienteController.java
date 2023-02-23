package com.example.cafeteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafeteria.model.UsuarioCliente;
import com.example.cafeteria.repository.UsuarioClienteRepository;

import jakarta.validation.Valid;

//import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioClienteController {

	@Autowired
	UsuarioClienteRepository usuarioClienteRepository;

	@GetMapping("/all") // busca tudo//
	public ResponseEntity<List<UsuarioCliente>> getAll() {
		return ResponseEntity.ok(usuarioClienteRepository.findAll());
	}

	@GetMapping("/{id}") // busca por id
	public ResponseEntity<UsuarioCliente> getById(@PathVariable Long id) {
		return usuarioClienteRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/usuario/{usuario}") // busca por usuario
	public ResponseEntity<UsuarioCliente> getByUsuario(@PathVariable String usuario) {
		return usuarioClienteRepository.findByUsuario(usuario).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioCliente> postUsuario(@Valid @RequestBody UsuarioCliente usuarioCliente){
		return service.cadastrarUsuario(usuarioCliente)
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	

	/*
	 * @PutMapping("/atualizar") public ResponseEntity<UsuarioCliente>
	 * putUsuario(@Valid @RequestBody UsuarioCliente usuarioCliente) {
	 * 
	 * return service.atualizarUsuario(usuarioCliente) .map(resposta ->
	 * ResponseEntity.ok(resposta))
	 * .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); }
	 */

}
