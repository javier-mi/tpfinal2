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
		try {
			SpringApplication.run(FinalApplication.class, args);
			//probar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Bean
	ApplicationRunner init(IUsuarioRepositorio usuarioRepositorio,
						   IFotoRepositorio fotoRepositorio) {
		return args -> {
			crearTablaUsuarios(usuarioRepositorio);
			crearTablaFotos(fotoRepositorio);
			
		};
		
	}

	private void crearTablaUsuarios(IUsuarioRepositorio usuarioRepositorio) throws Exception {
		try {
			ArrayList<Usuario> usuarios = obtenerDatosUsuarios();
			guardarDatosUsuarios(usuarioRepositorio, usuarios);
		} catch (Exception e) {
			throw new Exception("method crearTablaUsuarios" + e.getMessage());
		}
	}
	
	private void crearTablaFotos(IFotoRepositorio fotoRepositorio) throws Exception {
		try {
			ArrayList<Foto> fotos = obtenerFotos();
			guardarFotos(fotoRepositorio, fotos);
		} catch (Exception e) {
			throw new Exception("method crearTablaFotos" + e.getMessage());
		}
	}

	@SuppressWarnings("finally")
	public static ArrayList<Usuario> obtenerDatosUsuarios() throws Exception {
		ArrayList<Usuario> usuarios = null;
		try {
			LecturaExcel lecturaExcel = new LecturaExcel();
			usuarios = lecturaExcel.obtenerUsuarios();
		} catch (Exception e) {
			throw new Exception ("method obtenerFotos" + e.getMessage());
		} finally {
			return usuarios;
		}
	}

	public void guardarDatosUsuarios(IUsuarioRepositorio usuarioRepositorio,
			                         ArrayList<Usuario> usuarios) throws Exception {
		try {
			for (Usuario usuario: usuarios) {
				usuarioRepositorio.save(usuario);
			}
			usuarioRepositorio.findAll().forEach(System.out::println);
		} catch (Exception e) {
			throw new Exception ("method guardarDatosUsuarios" + e.getMessage());
		}
	}
	
	@SuppressWarnings("finally")
	public ArrayList<Foto> obtenerFotos() throws Exception {
		ArrayList<Foto> fotos = null;
		try {
			LecturaCarpeta lecturaCarpeta = new LecturaCarpeta();
			fotos = lecturaCarpeta.recorrerCarpeta();
		} catch (Exception e) {
			throw new Exception ("method obtenerFotos" + e.getMessage());
		} finally {
			return fotos;
		}
	}
	
	public void guardarFotos(IFotoRepositorio fotoRepositorio,
							 ArrayList<Foto> fotos) throws Exception {
		try {
			for (Foto foto: fotos) {
				fotoRepositorio.save(foto);
			}
			fotoRepositorio.findAll().forEach(System.out::println);
		} catch (Exception e) {
			throw new Exception ("method guardarFotos" + e.getMessage());
		}
	}
	
	public static void probar() throws Exception {
		try {
			LecturaExcel lecturaExcel = new LecturaExcel();
			lecturaExcel.obtenerUsuarios();
			
			LecturaCarpeta lecturaCarpeta = new LecturaCarpeta();
			lecturaCarpeta.recorrerCarpeta();
		} catch (Exception e) {
			throw new Exception ("method probar" + e.getMessage());
		}
	}

}
