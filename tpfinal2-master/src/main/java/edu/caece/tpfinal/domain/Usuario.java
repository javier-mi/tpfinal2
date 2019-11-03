package edu.caece.tpfinal.domain;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="usuario") 
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;

	@Column(name="email")
	private String email;

	@Column(name = "id_rol")
	private Double idRol;

	public Usuario() {
	
	}
	
	public Usuario(String nombre,
				   String apellido,
				   String email,
				   double idRol) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.idRol = idRol;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public Double getIdRol() {
		return idRol;
	}

	public void setIdRol(Double idRol) {
		this.idRol = idRol;
	}

	public String toString (){
        String datosUsuario = "Usuario::" + 
        					  nombre + ":" + 
        					  apellido + ":" + 
        					  email;
        return datosUsuario;
    }
}
