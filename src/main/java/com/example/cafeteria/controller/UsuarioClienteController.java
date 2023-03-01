package com.example.cafeteria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafeteria.model.UsuarioCliente;
import com.example.cafeteria.model.UsuarioLogin;
import com.example.cafeteria.repository.UsuarioClienteRepository;
import com.example.cafeteria.service.Service;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioClienteController {

	@Autowired
	UsuarioClienteRepository usuarioClienteRepository;

	@GetMapping("/all") 
	public ResponseEntity<List<UsuarioCliente>> getAll() {
		return ResponseEntity.ok(usuarioClienteRepository.findAll());
	}

	@GetMapping("/{id}") 
	public ResponseEntity<UsuarioCliente> getById(@PathVariable Long id) {
		return usuarioClienteRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/usuario/{usuario}") 
	public ResponseEntity<UsuarioCliente> getByUsuario(@PathVariable String usuario) {
		return usuarioClienteRepository.findByUsuario(usuario).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	/*@PostMapping("/logar")
	public ResponseEntity<UsuarioCliente> postUsuario(@RequestBody Optional<UsuarioLogin> usuario){
		return Service.logarUsuario(usuario)
				.map(resposta -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioCliente> postUsuario(@Valid @RequestBody UsuarioCliente usuarioCliente){
		return Service.cadastrarUsuario(usuarioCliente)
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}*/
	
	

	

}
