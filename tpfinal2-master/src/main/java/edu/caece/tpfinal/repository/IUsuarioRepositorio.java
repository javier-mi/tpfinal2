package edu.caece.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import edu.caece.tpfinal.domain.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
@CrossOrigin(origins = "http://localhost:4200")

public interface IUsuarioRepositorio extends JpaRepository<Usuario, String> {
	
	public Usuario findById(int id);

	public void deleteUsuarioById(int id);

}
