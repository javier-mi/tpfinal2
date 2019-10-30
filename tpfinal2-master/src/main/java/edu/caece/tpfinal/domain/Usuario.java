package edu.caece.tpfinal.domain;

import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="usuario") 
public class Usuario {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;

	@Column(name="email")
	private String email;

	@Column(name = "id_rol")
	private Integer idRol;

	public Usuario() {
	
	}
	
	public Usuario(String nombre,
				   String apellido,
				   String email,
				   int idRol) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.idRol = idRol;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	
	public String toString (){
        String datosUsuario = "Usuario::" + 
        					   nombre + ":" + 
        					   apellido +":" + 
        					   email +":" + 
        					   idRol;
        return datosUsuario;
    }

}
