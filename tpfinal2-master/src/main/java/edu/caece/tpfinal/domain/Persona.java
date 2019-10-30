package edu.caece.tpfinal.domain;
import javax.persistence.*;

@Entity
@Table(name="Persona") 
public class Persona {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "dni")
	private String dni;
	
	@ManyToOne
    @JoinColumn(name = "id_funcion")
    private Funcion funcion;
	
	@Column(name = "matricula")
	private String matricula;

	public Persona() {
		
	}
	
	public Persona(String nombre,
			       String apellido,
			       String dni,
			       String matricula) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.matricula = matricula;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
