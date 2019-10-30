package edu.caece.tpfinal.repository;

import java.util.List;

import edu.caece.tpfinal.domain.Persona;

public interface IPersonaDao {
	
	Persona getPersonaById(int personaId);

	void agregarPersona(Persona personaId);
	
	void eliminarPersona(int personaId);

	List<Persona> getPersonas();
	
}