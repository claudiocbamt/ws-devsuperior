package com.devsuperior.dscatalog.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.category;
import com.devsuperior.dscatalog.repositoryes.CategoryRepository;


@Service

public class CategoryService {
	
	@Autowired
	
	private CategoryRepository repository;
	
	@Transactional(readOnly= true) //não trava o banco de dados (loking)
	/*
	public List<category> BuscarTodos(){
		
		return repository.findAll();
		
	}
	*/
    public List<CategoryDTO> BuscarTodos(){
		
		List <category> lista =  repository.findAll();
		List <CategoryDTO> listaDTO =  new ArrayList<>();
		
		for(category cat : lista){
			
			
			listaDTO.add(new CategoryDTO(cat));
			
		}
		return listaDTO;
	}
	

}
