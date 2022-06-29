package com.generation.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licencias")

public class Licencia {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)


    private Long id;
    private Integer numero;
    //arregla la fecha en como se entrega la fecha de vencimiento en database
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaVencimiento;
    private String clase;
    private String estado;

    //OPCIONAL SIRVE LA PA GESTION DE LA BASE DE DATOS
@Column(updatable = false)//nunca se va a actualizar
//fecha de Creacion
private Date createdAt;

//fecha de actualizacion
private Date updatedAt;

//ELIMINACION LOGICA: no borrar, cambia estado 
/*fecha de eliminación= private Date deleteAt;*/


public Date getUpdatedAt() {
    return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
}
/*RELACIONES ONETOONE (1A1) desde licencia a usuario*/
//EAGER: carga automaticamente toda la info,busca todas las relaciones existentes
/*LAZY:se selecciona la relacion cuando se busca licencia nos traera el usuario asociado,
pero la carga del usuario se obtendra cuando consultemos por el usuario*/
@OneToOne(fetch = FetchType.LAZY)

//PK de la otra entidad, indicar como queremos que se relacionen
//agregar name= antes de la FK
//el que tiene joincolumn agrega la fk
@JoinColumn(name="usuario_id")

//tipo de objeto a relacionar
private Usuario usuario;


    //CONSTRUCTOR VACIO
    public Licencia(){
    }

    public Licencia(Long id, Integer numero, Date fechaVencimiento, String clase, String estado) {
        this.id = id;
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.clase = clase;
        this.estado = estado;
    }
    
//GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    //Insertará en el atributo en la fecha antes de insertar en bd
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }



}
