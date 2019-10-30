package edu.caece.tpfinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="Foto") 
public class Foto {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Lob
	@Column(name = "archivo")
	private byte[] archivo;
	
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
