package com.pequenoProjeto.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pequenoProjeto.course.entities.User;
import com.pequenoProjeto.course.repositories.UserRepository;

@Configuration //anotation pra informar que é uma classe de configuração
@Profile("test") //anotation pra informar qual o perfil vai usar as configurações dessa classe
public class TestConfig implements CommandLineRunner{
	
	@Autowired //anotation pra fazer a dependência automática já na declaração do objeto da classe que se vai fazer a dependência.
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//passando os uders pra salvar no BD através do UserRepository que implementou os métodos JpaRepository
		userRepository.saveAll(Arrays.asList(u1, u2)); 
		
	}

}
