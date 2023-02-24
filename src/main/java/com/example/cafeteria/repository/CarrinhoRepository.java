package com.example.cafeteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.cafeteria.model.Carrinho;


public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
	public List<Carrinho> findById(@Param("id") String id);
}
