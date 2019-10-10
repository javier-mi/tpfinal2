package edu.caece.tpfinal.domain;

import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="usuarios") 
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
	
	@Column(name="contrasenia")
	private String contrasenia;
	
	public Usuario() {
	
	}
	
	public Usuario(String nombre,
				   String apellido,
				   String email,
				   String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
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

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String toString (){
        String datosUsuario = "Usuario::" + 
        					  nombre + ":" + 
        					  apellido +":" + 
        					  email+":"+
        					  contrasenia;
        return datosUsuario;
    }

}
