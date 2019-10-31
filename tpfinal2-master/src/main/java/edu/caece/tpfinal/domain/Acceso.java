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
@Table(name="Acceso") 
public class Acceso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
	private Integer id = 0;
	
	@Column(name = "id_usuario")
	private String idUsuario;

	@Column(name = "fecha_acceso")
	private String fechaAcceso;
	
	public Acceso() {
		
	}
	
	public Acceso(String idUsuario,
			      String fechaAcceso) {
		this.idUsuario = idUsuario;
		this.fechaAcceso = fechaAcceso;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFechaAcceso() {
		return fechaAcceso;
	}

	public void setFechaAcceso(String fechaAcceso) {
		this.fechaAcceso = fechaAcceso;
	}

}
