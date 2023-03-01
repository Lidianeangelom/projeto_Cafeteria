package com.example.cafeteria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuario")
public class UsuarioCliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	
	@NotNull
	@Size(min=5)
	private String nome;
	
	@NotNull
	@Size(min=5)
	private String usuario;
	
	@NotNull
	@Size(min=5)
	private String email;
	
	@NotNull
	@Size(min=5)
	private String senha;
	
	@NotNull
	@Size(min=5)
	private String tipo_user;
	
	@NotNull
	private int cpf;
	
	@NotNull
	@Size(min=11)
	private int telefone;
	
	@NotNull
	@Size(min=5)
	private String foto_user;
	
	@NotNull
	@Size(min=5)
	private String endereco;
	
	@NotNull
	@Size(min=5)
	private String cep_cliente;
	
	
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo_user() {
		return tipo_user;
	}

	public void setTipo_user(String tipo_user) {
		this.tipo_user = tipo_user;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getFoto_user() {
		return foto_user;
	}

	public void setFoto_user(String foto_user) {
		this.foto_user = foto_user;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep_cliente() {
		return cep_cliente;
	}

	public void setCep_cliente(String cep_cliente) {
		this.cep_cliente = cep_cliente;
	}

	

	

}