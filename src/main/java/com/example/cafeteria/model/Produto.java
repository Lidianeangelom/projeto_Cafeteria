package com.example.cafeteria.model;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@NotNull
	@Size(min=5)
	private String tipo;
	
	//@NotNull
	@Size(min=5)
	private String nome;
	
	//@NotNull
	@Size(min=1)
	private String categoria;
	
	//@NotNull
	@Size(min=5)
	private String descricao;
	
	//@NotNull
	private float preco;
	
	//@NotNull
	@Size(min=4)
	private Date data_validade;
	
	//@NotNull
	@Size(min=5)
	private String fornecedor;
	
	//private boolean disponivel=true;
	
	//@NotNull
	@Size(min=5)
	private String foto;
	
	private long estoque;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Date getData_validade() {
		return data_validade;
	}

	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public long getEstoque() {
		return estoque;
	}

	public void setEstoque_id(long estoque) {
		this.estoque = estoque;
	}

	/*public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}*/
	
	
	
	
	
	
	
	
	
	
}
