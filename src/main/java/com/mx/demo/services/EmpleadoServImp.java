package com.mx.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mx.demo.entity.Empleado;
import com.mx.demo.repository.EmpleadoRepository;



@Service
public class EmpleadoServImp implements EmpleadoService{

	@Autowired
	private EmpleadoRepository repository;
	
	@Override
	public Iterable<Empleado> encontrarTodos() {		
		return repository.findAll();
	}

	/*
	public Empleado buscarXNombre(String name) {		
		return repository.buscarNombre(name).orElse(null);
	}
	*/

	@Override
	public Empleado encontrarUno(Long id) {	
		return repository.findById(id).orElseThrow(()-> new RuntimeException("No existe el cliente"));
	}

	@Override
	public void guardar(Empleado empleado) {
		repository.save(empleado);
		
	}
	
	@Override
	public void eliminar(Long id) {		
		repository.deleteById(id);
	}	

	@Override
	public void editar(Empleado empleado) {
		repository.save(empleado);		
	}

	@Override
	public List<Empleado> listar() {
		return (List<Empleado>) repository.findAll();
	}

	@Override
	public Page<Empleado> findAl(Pageable pageable) {
		return repository.findAll(pageable);
	}

}
