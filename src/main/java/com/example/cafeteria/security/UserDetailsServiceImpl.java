package com.example.cafeteria.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.cafeteria.model.UsuarioCliente;
import com.example.cafeteria.repository.UsuarioClienteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioClienteRepository usuarioClienteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) 
			throws UsernameNotFoundException {
		Optional<UsuarioCliente> usuarioCliente = usuarioClienteRepository.findByUsuario(userName);
		usuarioCliente.orElseThrow(() -> new UsernameNotFoundException(userName + "não encontrado."));
		
		return usuarioCliente.map(UserDetailsImpl::new).get();
	}

}