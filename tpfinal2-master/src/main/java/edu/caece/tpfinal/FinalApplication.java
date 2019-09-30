package edu.caece.tpfinal;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import edu.caece.tpfinal.domain.User;
import edu.caece.tpfinal.repository.UserRepository;

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
	ApplicationRunner init(UserRepository repository) {
		return args -> {
			Stream.of("Francisco Ferrari;891602;32256985;Alumno", "Javier Michelson;902355;25236589;Alumno", 
					"Juan Salinas;912565;32256951;Alumno", "Pablo Garcia;925689;32456852;Alumno").forEach(alumno -> {
				User user = new User();
				String[] datos = alumno.split(";");
				user.setName(datos[0]);
				user.setMatricula(datos[1]);
				user.setDni(datos[2]);
				user.setDescription(datos[3]);
				repository.save(user);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
