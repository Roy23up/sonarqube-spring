package com.mx.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.demo.entity.Users;

@Repository
public interface UsuarioRepository extends JpaRepository<Users, Integer>{
	
	Optional<Users> findByUsuario(String usuario);
	boolean existsByUsuario(String usuario);

}
