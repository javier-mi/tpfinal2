package edu.caece.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import edu.caece.tpfinal.domain.Persona;

@RepositoryRestResource(collectionResourceRel = "personas", path = "personas")
@CrossOrigin(origins = "http://localhost:4200")

public interface IPersonaRepositorio extends JpaRepository<Persona, String> {

}
