package edu.caece.tpfinal.repository;

import java.util.List;

import edu.caece.tpfinal.domain.Persona;

public interface IPersonaDao {

	List<Persona> getPersonas() throws Exception;
	
}