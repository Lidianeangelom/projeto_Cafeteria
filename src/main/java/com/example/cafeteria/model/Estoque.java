package com.example.cafeteria.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "estoque")
public class Estoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=2)
	private String nome;
	
	@NotNull
	@Size(min=4)
	private Date data_entrada;
	
	@NotNull
	@Size(min=4)
	private Date data_saida;
	
	@NotNull
	private float faturamento;
	
	@NotNull
	private int estoque_inicial;
	
	@NotNull
	private int estoque_atual;
	
	@OneToMany(mappedBy="Produto", cascade=CascadeType.ALL)
	private List<Produto> produto;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

	public float getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(float faturamento) {
		this.faturamento = faturamento;
	}

	public int getEstoque_inicial() {
		return estoque_inicial;
	}

	public void setEstoque_inicial(int estoque_inicial) {
		this.estoque_inicial = estoque_inicial;
	}

	public int getEstoque_atual() {
		return estoque_atual;
	}

	public void setEstoque_atual(int estoque_atual) {
		this.estoque_atual = estoque_atual;
	}
	
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	

}
