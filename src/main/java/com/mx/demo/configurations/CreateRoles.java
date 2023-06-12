package com.mx.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.mx.demo.services.RolService;

@Service
public class CreateRoles implements CommandLineRunner{

	@Autowired
	RolService rolService;
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
