package com.mx.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mx.demo.services.RolService;
import com.mx.demo.services.UsuarioService;

@Service
public class CreateAdmin implements CommandLineRunner{

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	RolService rolService;
	
	@Override
	public void run(String... args) throws Exception {		
		
	}

}
