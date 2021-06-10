package com.pequenoProjeto.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pequenoProjeto.course.entities.User;
import com.pequenoProjeto.course.repositories.UserRepository;

// @Component -> anotation que registra essa classe como componente do spring e permite a sua injeção de dependência em outras classes.
@Service //-> o spring possui uma anotation específica de serviço que substitui a @Component que é mais genérica
//obs: o spring também tem uma anotation específica para classe repository.
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

}
