package edu.caece.tpfinal.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Foto") 
public class Foto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
	private Integer id = 0;
	
	@Lob
	@Column(name = "archivo")
	private byte[] archivo;
	
	@Column(name="nombre_archivo")
	private String nombreArchivo;

	@Column(name="id_persona")
	private String idPersona;
	
	public Foto(byte[] archivo, 
				String idPersona) {
		this.archivo = archivo;
		this.idPersona = idPersona;
	}
	
	public Foto() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	
	public String toString (){
        String datosFoto = "Foto::" +
        					archivo + ":" +
        					idPersona;
        return datosFoto;
    }

}
