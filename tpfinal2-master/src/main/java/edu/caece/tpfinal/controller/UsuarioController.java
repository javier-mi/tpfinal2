package edu.caece.tpfinal.controller;

import java.util.Collection;
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
	public Collection<Usuario> users() {
		return usuarioRepositorio.findAll().stream().collect(Collectors.toList());
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario user(String id) {
		return usuarioRepositorio.getOne(id);
	}
	
	@PostMapping("/usuarios/save")
	public void save(@RequestBody Usuario usuario) {
		this.usuarioRepositorio.save(usuario);
	}
	
	@DeleteMapping("/usuarios/delete/{id}")
	public void delete(Long id) {

	}

}
