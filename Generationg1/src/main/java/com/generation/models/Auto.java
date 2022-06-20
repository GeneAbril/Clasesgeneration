package com.generation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="autos")
public class Auto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private Float velocidad;
	private String color;
	public Auto() {
		super();
	}
	public Auto(Long id, String marca, String modelo, Float velocidad, String color) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.velocidad = velocidad;
		this.color = color;
	}
	public Long getId() {
		return id;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public Float getVelocidad() {
		return velocidad;
	}
	public String getColor() {
		return color;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setVelocidad(Float velocidad) {
		this.velocidad = velocidad;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	

}