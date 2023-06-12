package com.mx.demo.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mx.demo.entity.Users;
import com.mx.demo.services.UsuarioService;

public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = usuarioService.getByUsuario(username).orElseThrow(() -> new UsernameNotFoundException(username));
		return UsuarioPrincipal.build(users);
	}
	
}
