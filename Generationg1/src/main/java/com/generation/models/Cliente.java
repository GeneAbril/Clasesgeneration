package com.generation.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private String apellido;
private String email;


@Column(updatable=false)
private Date createdAt;

//fecha de actualizacion
private Date updatedAt;

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

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public Date getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
}

public Date getUpdatedAt() {
    return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
}

public Cliente(String nombre, String apellido, String email, Date createdAt, Date updatedAt) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
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