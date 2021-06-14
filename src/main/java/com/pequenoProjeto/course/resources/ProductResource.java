package com.pequenoProjeto.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pequenoProjeto.course.entities.Product;
import com.pequenoProjeto.course.services.ProductService;

@RestController //identificação de um controller
@RequestMapping(value = "/products") //identificação do endereço URL pra acessar essa classe
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);// -> para retornar uma resposta de sucesso do HTTP e a lista ser essa resposta.
	}
	
	@GetMapping(value = "/{id}") //-> informa que a requisição vai aceitar um id dentro da URL
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
