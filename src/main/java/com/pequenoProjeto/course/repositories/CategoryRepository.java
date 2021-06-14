package com.pequenoProjeto.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pequenoProjeto.course.entities.Category;

@Repository //-> anotation que indica essa classe como repository. No caso do repository, a anotation é opcional.
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
