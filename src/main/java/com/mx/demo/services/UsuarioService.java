package com.mx.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.demo.entity.Users;
import com.mx.demo.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Users> lista() {
		return usuarioRepository.findAll();
	}

	public Optional<Users> getById(int id) {
		return usuarioRepository.findById(id);
	}
	
	public Optional<Users> getByUsuario(String usuario){
		return usuarioRepository.findByUsuario(usuario);
	}

	public void guardarUsuario(Users users) {
		usuarioRepository.save(users);
	}
	
	public boolean existsById(int id) {
		return usuarioRepository.existsById(id);
	}
	
	public boolean existsByNombreUsuario(String usuario) {
		return usuarioRepository.existsByUsuario(usuario);
	}
	
}
