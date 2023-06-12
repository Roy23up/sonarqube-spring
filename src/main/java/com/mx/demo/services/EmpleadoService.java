package com.mx.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mx.demo.entity.Empleado;


public interface EmpleadoService {

	Iterable<Empleado> encontrarTodos();
	
	List<Empleado> listar();
	
	Empleado encontrarUno(Long id);
	
	public void guardar(Empleado empleado);
	
	public void eliminar(Long id);
	
	public void editar(Empleado empleado);
		
	Page<Empleado> findAl(Pageable pageable); 
	
}
