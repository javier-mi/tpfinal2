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
	"edu.caece.tpfinal"
//	"edu.caece.tpfinal.config",
//	"edu.caece.tpfinal.config.security"
})
//@ComponentScan(basePackages = { 
//@EnableAutoConfiguration
//@Configuration
@Import({WebSecurity.class})
public class FinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository repository) {
		return args -> {
			Stream.of("Fulano", "Mengano", "Sultano").forEach(name -> {
				User user = new User();
				user.setName(name);
				repository.save(user);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
