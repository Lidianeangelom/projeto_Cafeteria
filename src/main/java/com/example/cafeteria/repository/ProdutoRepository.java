package com.example.cafeteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.cafeteria.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findByNome(@Param("nome") String nome);

	public Object findAllByNome(String nome);

	public Object findByPreco(@Param("preco")Float preco);
}
