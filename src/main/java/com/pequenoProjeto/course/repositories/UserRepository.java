package com.pequenoProjeto.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//a classe repository já possui uma série de métodos implícitos que nos permitem manipular os atributos da classe 
//usuers como também lançar essas modificações no BD ou trazer informações do BD.

import com.pequenoProjeto.course.entities.User;

@Repository //-> anotation que indica essa classe como repository. No caso do repository, a anotation é opcional.
public interface UserRepository extends JpaRepository<User, Long>{

}
