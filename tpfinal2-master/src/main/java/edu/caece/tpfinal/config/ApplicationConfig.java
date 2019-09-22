package edu.caece.tpfinal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Value("tpfinal.security.username")
	public String username;
	
	@Value("tpfinal.security.password")
	public String password;
	
}
