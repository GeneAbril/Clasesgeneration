package com.generation.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
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
	private String password;
	private Integer edad;//no establecer limite de caracteres
	
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
	//ONETOONE desde usuario a licencia//
	//MAPEAR a traves de usuario relacionar licencia con usuario-> cascade: restringe a eliminacion de usuario, primero se debe romper la relacion-> buscar licencia al consultar
	@OneToOne(mappedBy="usuario",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	//tipo de objeto a relacionar
	private Licencia licencia;

	//MANYTOMANY
@ManyToMany(fetch =FetchType.EAGER)//EAGER ENTREGA TODA LA INFO
@JoinTable(
	name="roles_usuarios",//nombre de tabla a relacionar
	joinColumns = @JoinColumn(name="usuario_id"),//establecer desde la entidad actual
	inverseJoinColumns= @JoinColumn(name="rol_id")//establecer la otra entidad o tabla
)
private List<Rol> roles;



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

	public Licencia getLicencia() {
		return licencia;
	}

	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
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

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
