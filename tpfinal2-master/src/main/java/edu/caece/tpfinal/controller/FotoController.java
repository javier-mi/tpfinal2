package edu.caece.tpfinal.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.caece.tpfinal.domain.Foto;
import edu.caece.tpfinal.repository.IFotoRepositorio;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FotoController {
	
	@Autowired
	private IFotoRepositorio fotoRepositorio;
	
	@GetMapping("/fotos")
	public Collection<Foto> fotos() throws Exception {
		Collection<Foto> fotos = null;
		try {
			fotos = fotoRepositorio.findAll().stream().collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception("method fotossss :: " + e.getMessage());
		}
		return fotos;
	}
}
