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
public class GenericController {
	
	@Autowired
	private IUsuarioRepositorio userRepository;
	
	@GetMapping("/users")
	public Collection<Usuario> users() {
		return userRepository.findAll().stream().collect(Collectors.toList());
	}
	
	@PostMapping("/users/save")
	public void save(@RequestBody Usuario user) {
		this.userRepository.save(user);
	}
	
	@DeleteMapping("/users/delete/{id}")
	public void delete(Long id) {
		// TODO
	}

}
