package com.example.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.cafeteria.model.Produto;
import com.example.cafeteria.repository.ProdutoRepository;

public class Service {
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	@Override
	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}



}
