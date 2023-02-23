package com.example.cafeteria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeteria.model.UsuarioCliente;

public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Long>{

	public Optional<UsuarioCliente> findByUsuario(String usuario);
	
}
