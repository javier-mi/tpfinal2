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

import edu.caece.tpfinal.domain.Persona;
import edu.caece.tpfinal.repository.IPersonaRepositorio;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
	
	@Autowired
	private IPersonaRepositorio personaRepositorio;
	
	@GetMapping("/personas")
	public Collection<Persona> users() {
		return personaRepositorio.findAll().stream().collect(Collectors.toList());
	}
	
	@PostMapping("/personas/save")
	public void save(@RequestBody Persona persona) {
		this.personaRepositorio.save(persona);
	}
	
	@DeleteMapping("/personas/delete/{id}")
	public void delete(Long id) {

	}

}
