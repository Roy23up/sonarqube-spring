/*package com.mx.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mx.demo.entity.Users;
import com.mx.demo.repository.UsersRepository;



public class UsersServImp implements UsersService{

	@Autowired
	private UsersRepository repository;
	
	@Override
	public void guardar(Users usuario) {
		repository.save(usuario);		
	}

	@Override
	public void editar(Users usuario) {
		repository.save(usuario);		
	}

	@Override
	public void eliminar(Users usuario) {
		repository.delete(usuario);
	}

	@Override
	public Users buscar(Users usuario) {
		return repository.findById(usuario.getId()).orElse(null);
	}

	@Override
	public List<Users> list() {		
		return (List<Users>) repository.findAll();
	}

}
*/
