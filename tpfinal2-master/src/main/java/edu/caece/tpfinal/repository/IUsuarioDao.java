package edu.caece.tpfinal.repository;

import java.util.List;

import edu.caece.tpfinal.domain.Usuario;

public interface IUsuarioDao {
		
	List<Usuario> getUsuarios() throws Exception;
	
	public Usuario findById(int id) throws Exception;

	Usuario getUsuarioById(int usuarioId) throws Exception;
	
	void deleteUsuario(int usuarioId) throws Exception;
	
}