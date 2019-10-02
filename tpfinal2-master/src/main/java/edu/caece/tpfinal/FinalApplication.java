package edu.caece.tpfinal;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import edu.caece.tpfinal.domain.Usuario;
import edu.caece.tpfinal.repository.IUsuarioRepositorio;

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
	ApplicationRunner init(IUsuarioRepositorio repository) {
		return args -> {
			Stream.of("Francisco; Ferrari; ff@gmail.com; ffff", 
					  "Javier; Michelson; jm@gmail.com; jjjj", 
					  "Juan; Salinas; js@gmail.com; ssss", 
					  "Pablo; Garcia; pg@gmail.com; gggg").forEach(alumno -> {
				Usuario usuario = new Usuario();
				String[] datos = alumno.split(";");
				usuario.setNombre(datos[0]);
				usuario.setApellido(datos[1]);
				usuario.setEmail(datos[2]);
				usuario.setContrasenia(datos[3]);
				repository.save(usuario);
			});
			repository.findAll().forEach(System.out::println);
			
			//ConfigurableApplicationContext context = SpringApplication.run(FinalApplication.class);
			//UsuarioRepositorio repositorio = context.getBean(UsuarioRepositorio.class);

	        // Guardar un conjunto de usuarios
			//repositorio.save(new Usuario("Natalia", "Gonzalez", "ng@gmail.com", "gggg"));

	        // findAll heredado de la interface CrudRepository
			//Iterable<Usuario> todos = repository.findAll();
			//System.out.println("Listar todos los Usuarios:");
			//for (Usuario usr : todos) {
			//System.out.println("\t" + usr);
			//}
			//System.out.println();

			//context.close();
		};
	}
}
