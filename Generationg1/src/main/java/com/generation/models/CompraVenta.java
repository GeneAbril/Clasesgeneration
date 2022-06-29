package com.generation.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="comprasVentas")//recordar revisar la tabla
public class CompraVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Range(min=0)  //Range <> Size(min=2) -99
	private Float monto;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	//ManyToOne FK 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	
	@Column(updatable= false)
	private Date createdAt;
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	private Date updatedAt;
	
	public CompraVenta() {
		super();
	}

	public CompraVenta(@Range(min = 0) Float monto, Date fecha, Cliente cliente) {
		super();
		this.monto = monto;
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public Float getMonto() {
		return monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
