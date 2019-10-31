package edu.caece.tpfinal.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Rol_Permiso") 
public class Rol_Permiso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
	private Integer id = 0;
	
	@Column(name = "id_rol")
	private Integer id_rol;
	
	@Column(name = "id_permiso")
	private Integer id_permiso;
	
	public Rol_Permiso() {
		
	}
	
	public Rol_Permiso(Integer idRol,
			Integer idPersona) {
		this.id_rol = idRol;
		this.id_permiso = idPersona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRol() {
		return id_rol;
	}

	public void setIdRol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public Integer getIdPermiso() {
		return id_permiso;
	}

	public void setIdPermiso(Integer id_permiso) {
		this.id_permiso = id_permiso;
	}	

}
