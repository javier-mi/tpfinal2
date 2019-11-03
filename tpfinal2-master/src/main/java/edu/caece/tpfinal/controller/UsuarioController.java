package edu.caece.tpfinal.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.caece.tpfinal.domain.Usuario;
import edu.caece.tpfinal.repository.IUsuarioRepositorio;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepositorio usuarioRepositorio;
	
	@GetMapping("/usuarios")
	public Collection<Usuario> usuarios() throws Exception {
		Collection<Usuario> usuarios = null;
		try {
			usuarios = usuarioRepositorio.findAll().stream().collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception("method usuarios :: " + e.getMessage());
		}
		return usuarios;
	}
	
	@GetMapping("/usuarios/{id}")
	public Optional<Usuario> user(String id) throws Exception {
		Optional<Usuario>  usuario = null;
		try {
			usuario = usuarioRepositorio.findById(id);
		} catch (Exception e) {
			throw new Exception("method usuarios :: " + e.getMessage());
		}
		return usuario;
	}
	
	@PostMapping("/usuarios/save")
	public void save(@RequestBody Usuario usuario) throws Exception {
		this.usuarioRepositorio.save(usuario);
	}
	
	@DeleteMapping("/usuarios/delete")
	public void delete(@RequestBody Usuario usuario) throws Exception {
		this.usuarioRepositorio.delete(usuario);
	}

}
