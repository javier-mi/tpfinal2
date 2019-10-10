package edu.caece.tpfinal;

import java.util.ArrayList;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import edu.caece.tpfinal.repository.IUsuarioRepositorio;
import edu.caece.tpfinal.repository.IFotoRepositorio;

import edu.caece.tpfinal.domain.Usuario;
import edu.caece.tpfinal.domain.Foto;

import edu.caece.tpfinal.resources.LecturaCarpeta;
import edu.caece.tpfinal.resources.LecturaExcel;


@SpringBootApplication(scanBasePackages= {
	"edu.caece.tpfinal",
	"edu.caece.tpfinal.config",
	"edu.caece.tpfinal.config.security"
})
//@ComponentScan(basePackages= { "Error: Could not find or load main class edu.caece.tpfinal.FinalApplication" })
//@EnableAutoConfiguration
@Configuration
@Import({WebSecurity.class})
public class FinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalApplication.class, args);
	}

	@Bean
	ApplicationRunner init(IUsuarioRepositorio usuarioRepositorio,
						   IFotoRepositorio fotoRepositorio) {
		return args -> {
			crearTablaUsuarios(usuarioRepositorio);
			crearTablaFotos(fotoRepositorio);
			
		};
	}
	
	public void crearTablaUsuarios(IUsuarioRepositorio usuarioRepositorio) throws Exception {
		try {
			LecturaExcel lecturaDatos = new LecturaExcel();
			lecturaDatos.leerExcel();
			ArrayList<Usuario> usuarios = lecturaDatos.obtenerUsuarios();
			for (Usuario usuario: usuarios) {
				usuarioRepositorio.save(usuario);
			}
			usuarioRepositorio.findAll().forEach(System.out::println);
		} catch (Exception e) {
			throw new Exception ("method crearTablaUsuarios" + e.getMessage());
		}
	}
	
	public void crearTablaFotos(IFotoRepositorio fotoRepositorio) throws Exception {
		try {
			LecturaCarpeta lecturaCarpeta = new LecturaCarpeta();
			ArrayList<Foto> fotos = lecturaCarpeta.recorrerCarpeta();
			for (Foto foto: fotos) {
				fotoRepositorio.save(foto);
			}
			fotoRepositorio.findAll().forEach(System.out::println);
		} catch (Exception e) {
			throw new Exception ("method crearTablaFotos" + e.getMessage());
		}
	}
}
