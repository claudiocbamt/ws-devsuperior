package com.devsuperior.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.entities.category;
import com.devsuperior.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")


public class CategoryResource {
	@Autowired
	private CategoryService service;
	@GetMapping
	
	public ResponseEntity <List<category>> findAll(){
		
		List<category> lista = service.findAll();
		
		
		//lista.add(new category(1L, "Books"));
		//lista.add(new category(2L,"Electronics"));
		
		return ResponseEntity.ok().body(lista);
	}
	

}
