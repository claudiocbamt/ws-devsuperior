package com.devsuperior.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.entities.category;

@RestController
@RequestMapping(value = "/categories")


public class CategoryResource {
	@GetMapping
	public ResponseEntity <List<category>> findAll(){
		
		List<category> lista = new ArrayList<>();
		
		lista.add(new category(1L, "Books"));
		lista.add(new category(2L,"Electronics"));
		
		return ResponseEntity.ok().body(lista);
	}
	

}
