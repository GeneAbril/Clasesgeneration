package com.generation.models;

import java.util.Date;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
	private Float valor;

public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
public Auto(Float valor) {
		this.valor = valor;
	}
//MANY TO MANI con AUTOS_VENTAS no es many to one
@ManyToMany(fetch =FetchType.EAGER)//EAGER ENTREGA TODA LA INFO
@JoinTable(
	name="auto_ventas",//nombre de tabla a relacionar
	joinColumns = @JoinColumn(name="auto_id"),//establecer desde la entidad actual
	inverseJoinColumns= @JoinColumn(name="compra_venta_id")//establecer la otra entidad o tabla, otra relacion de tabla autoventas
)
private List<CompraVenta> comprasVentas;// hacer lista de compra_venta



	@Column(updatable = false)//nunca se va a actualizar
private Date createdAt;

//fecha de actualizacion
private Date updatedAt;


	public Date getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}
	public Auto(Date updatedAt) {
	this.updatedAt = updatedAt;
}
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
	//Insertará en el atributo en la fecha antes de insertar en bd
	//no influye donde se coloque prepersist y reupdate
	@PrePersist//le asigna la fecha antes de guardar
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate//le asigna la fecha antes de actualizar
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


}