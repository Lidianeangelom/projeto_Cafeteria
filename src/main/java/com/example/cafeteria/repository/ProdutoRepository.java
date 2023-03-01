package com.example.cafeteria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeteria.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAll();

	Optional<Produto> findById(Long id);
	
	Optional<Produto> findByCategoria(String categoria);



}
