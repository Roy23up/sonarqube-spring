package com.mx.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.demo.entity.Empleado;

@Repository
public interface EmpleadoRepository extends PagingAndSortingRepository<Empleado, Long>{

	//public Empleado encontrarByNombre(String nombre);
	
	/*
	@Query(value = "select*from empleado e where e.nombre = :nombre?", nativeQuery = true)
	public Empleado buscarNombre(@Param("nombre") String nombre);
	*/
	
}
