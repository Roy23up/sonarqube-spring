package com.mx.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mx.demo.entity.Rol;
import com.mx.demo.enums.RolNombre;
import com.mx.demo.repository.RolRepository;

@Service
@Transactional
public class RolService {

	private RolRepository rolRepository;
	
	public void guardar(Rol rol) {
		rolRepository.save(rol);
	}
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return rolRepository.findByRolNombre(rolNombre);
	}
	
	public boolean existsByRolNombre(RolNombre rolNombre) {
		return rolRepository.existsByRolNombre(rolNombre);
	}
}
