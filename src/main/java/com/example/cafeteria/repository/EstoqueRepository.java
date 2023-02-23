package com.example.cafeteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.cafeteria.model.Estoque;


public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
	public List<Estoque> findById(@Param("id") String id);
}
