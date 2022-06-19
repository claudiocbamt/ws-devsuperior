package com.devsuperior.dscatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dscatalog.entities.category;
import com.devsuperior.dscatalog.repositoryes.CategoryRepository;


@Service

public class CategoryService {
	
	@Autowired
	
	private CategoryRepository repository;
	
	public List<category> findAll(){
		
		return repository.findAll();
		
	}
	

}
