package com.generation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // objeto se convierte en entidad
@Table(name = "usuarios") // se establece nombre en base de datos

//OBJETO USUARIO

public class Usuario {
	@Id // ESTABLECER PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //
	private Long id;// ESTE ATRIBUTO ESTABLECE COLUMNA ID, LA PK

	// ATRIBUTOS
	@Size(min = 3, max = 20) // limita cantidad de caracteres
	private String nombre;

	@Size(min = 3, max = 20) // limita cantidad de caracteres
	private String apellido;

	@NotNull()
	@Size(min = 6, max = 8)
	private String password;
	private Integer edad;//no establecer limite de caracteres
//CONSTRUCTOR VACIO
	public Usuario() {
		super();
	}

//CONSTRUCTOR CON PARAMETRO
	public Usuario(String nombre, String apellido, Integer edad, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.password = password;
	}

//GETTERS AND SETTERS DE ID y password PUESTO EN USUARIOS 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
