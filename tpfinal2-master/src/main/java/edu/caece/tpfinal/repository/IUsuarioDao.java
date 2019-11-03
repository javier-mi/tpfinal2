package edu.caece.tpfinal.repository;

import java.util.List;

import edu.caece.tpfinal.domain.Usuario;

public interface IUsuarioDao {
	
	Usuario getUsuarioById(int usuarioId);
	
	List<Usuario> getUsuarios();

}