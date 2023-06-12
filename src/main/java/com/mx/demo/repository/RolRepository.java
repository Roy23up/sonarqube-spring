package com.mx.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.demo.entity.Rol;
import com.mx.demo.enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	
	Optional<Rol> findByRolNombre(RolNombre rolNombre);
	boolean existsByRolNombre(RolNombre rolNombre);

}
