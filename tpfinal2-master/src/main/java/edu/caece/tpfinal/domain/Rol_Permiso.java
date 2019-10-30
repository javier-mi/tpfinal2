package edu.caece.tpfinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rol_Permiso") 
public class Rol_Permiso {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
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
