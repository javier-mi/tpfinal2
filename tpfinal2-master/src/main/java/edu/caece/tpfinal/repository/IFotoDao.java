package edu.caece.tpfinal.repository;

import java.util.List;

import edu.caece.tpfinal.domain.Foto;

public interface IFotoDao {
	
	Foto getFotoById(int fotoId);

	boolean fotoExiste(String email, String contrasenia);

	void agregarFoto(Foto foto);
	
	void eliminarFoto(int usuarioId);

	List<Foto> getFotos();
	
}