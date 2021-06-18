package com.pequenoProjeto.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pequenoProjeto.course.entities.User;
import com.pequenoProjeto.course.repositories.UserRepository;
import com.pequenoProjeto.course.services.exceptions.DataBaseException;
import com.pequenoProjeto.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {// -> chamada do método do repository para inserir novo user
		return repository.save(obj);
	}
	
	public void delete(Long id) {// -> chamada do método do repository para deletar um user
		try {
		repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
		User entity = repository.getOne(id); //->método do JPA que instancia um objeto sem passar para o banco de dados
		updateData(entity, obj);
		return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}

}
