package edu.caece.tpfinal.repository;

import java.util.List;

import edu.caece.tpfinal.domain.Usuario;

public interface IUsuarioDao {
	
	Usuario getUsuarioById(int usuarioId);

	boolean usuarioExiste(String email, String contrasenia);

	void agregarUsuario(Usuario usuario);
	
	void eliminarUsuario(int usuarioId);

	List<Usuario> getUsuarios();
	
}