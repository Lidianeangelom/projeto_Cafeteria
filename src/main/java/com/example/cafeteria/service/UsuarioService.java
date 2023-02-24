package com.example.cafeteria.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.cafeteria.model.UsuarioCliente;
import com.example.cafeteria.model.UsuarioLogin;
import com.example.cafeteria.repository.UsuarioClienteRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioClienteRepository usuarioClienteRepository;

	public Optional<UsuarioCliente> cadastrarUsuario(UsuarioCliente usuarioCliente) {

		if(usuarioClienteRepository.findByUsuario(usuarioCliente.getUsuario()).isPresent())
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já Existe!", null);
		
	usuarioCliente.setSenha(criptografarSenha(usuarioCliente.getSenha()));
	
	return Optional.of(usuarioClienteRepository.save(usuarioCliente));
	
	}

	public Optional<UsuarioCliente> atualizarUsuario(UsuarioCliente usuarioCliente){
		
		if(usuarioClienteRepository.findById(usuarioCliente.getId()).isPresent()){
			Optional<UsuarioCliente> buscaUsuario = usuarioClienteRepository.findByUsuario(usuarioCliente.getUsuario());
			
			if (buscaUsuario.isPresent()) {
				
				if(buscaUsuario.get().getId() != usuarioCliente.getId())
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
			}
			usuarioCliente.setSenha(criptografarSenha(usuarioCliente.getSenha()));
			return Optional.of(usuarioClienteRepository.save(usuarioCliente));
					
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
	}
	
	public Optional<UsuarioLogin> logarUsuario(Optional<UsuarioLogin> usuarioLogin){
		
		Optional<UsuarioCliente> usuario = usuarioClienteRepository.findByUsuario(usuarioLogin.get().getUsuario());
		
		if (usuario.isPresent()) {
			if (compararSenhas(usuarioLogin.get().getSenha(),
			usuario.get().getSenha())) {
			usuarioLogin.get().setId(usuario.get().getId());
			usuarioLogin.get().setNome(usuario.get().getNome());
			usuarioLogin.get().setToken(
			gerarBasicToken(usuarioLogin.get().getUsuario(),
			usuarioLogin.get().getSenha()));
			usuarioLogin.get().setSenha(usuario.get().getSenha());
			return usuarioLogin;
			}
			}
			throw new ResponseStatusException(
			HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos!", null);

	}
	
	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(senha);
		return senhaEncoder;
		}
		private boolean compararSenhas(String senhaDigitada,
		String senhaBanco) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(senhaDigitada, senhaBanco);
		}
		private String gerarBasicToken(String email, String password) {
		String estrutura = email + ":" + password;

		byte[] estruturaBase64 = Base64.encodeBase64(
				estrutura.getBytes(Charset.forName("US-ASCII")));
				return "Basic " + new String(estruturaBase64);
				}
		
}

	
