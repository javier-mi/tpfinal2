package edu.caece.tpfinal.repository;

import java.util.List;

import edu.caece.tpfinal.domain.Usuario;

public interface IUsuarioDao {
		
	List<Usuario> getUsuarios();

	Usuario getUsuarioById(int usuarioId);
	
	void deleteUsuario(int usuarioId);
	
}