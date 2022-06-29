package com.generation.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AutosVentas")//recordar revisar la tabla
//DETALLE DE VENTA - TABLA RELACIONAL 
public class AutoVentas {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    private float subtotal;
    private Date fecha;

    /*MANY TO MANY = 2 MANY TO ONE */
    
    //MANY TO ONE con AUTO
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="auto_id")
	private Auto auto;


    //MANY TO ONE con COMPRAVENTA
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="compra_venta_id")//se escribe con guion para separar
	private CompraVenta compraVenta;

//CONSTRUCTOS VACIO
    public AutoVentas() {
    }

//CONSTRUCTOS CON PARAMETROS, 
    public AutoVentas(Long id, Integer cantidad, float subtotal, Date fecha, Auto auto, CompraVenta compraVenta) {
        this.id = id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.fecha = fecha;
        this.auto = auto;
        this.compraVenta = compraVenta;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Integer getCantidad() {
        return cantidad;
    }


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public float getSubtotal() {
        return subtotal;
    }


    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Auto getAuto() {
        return auto;
    }


    public void setAuto(Auto auto) {
        this.auto = auto;
    }


    public CompraVenta getCompraVenta() {
        return compraVenta;
    }


    public void setCompraVenta(CompraVenta compraVenta) {
        this.compraVenta = compraVenta;
    }

}
