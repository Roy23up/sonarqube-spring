package com.mx.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado implements Serializable{

	/**
	 * creado por el serializable del ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(name = "nombre", nullable = false, unique = true)
	@NotEmpty(message = "El nombre es obligatorio")
	private String nombre;
	
	@Column(unique = true)
	@NotEmpty
	@Max(value = 10, message = "Se debe agregar un número valido")
	private String telefono;
	
	
}
