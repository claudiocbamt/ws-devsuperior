package com.devsuperior.dscatalog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.category;
import com.devsuperior.dscatalog.repositoryes.CategoryRepository;
import com.devsuperior.dscatalog.services.exceptions.DataBaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;


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
	
	@Transactional(readOnly= true) //não trava o banco de dados (loking)
	
	 public CategoryDTO BuscarPorId(long Id){
			
			Optional <category> obj = repository.findById(Id);
			
			//category entity = obj.get();
			category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Foun"));
			return new CategoryDTO(entity);
		}
	@Transactional
	public CategoryDTO Inserir(CategoryDTO dto) {
		
		category entidade = new category();
		entidade.setName(dto.getName());
		 entidade = repository.save(entidade);
		// TODO Auto-generated method stub
		return new CategoryDTO(entidade);
	}
	@Transactional
	public CategoryDTO Atualizar(Long id, CategoryDTO dto) {
		try {
		category entidade = repository.getById(id);
		entidade.setName(dto.getName());
		entidade = repository.save(entidade);
		return new CategoryDTO(entidade);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		}
		
	}

	public void Excluir(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		}
		
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Violação de Integridade ");
		}
		
	}
		

}
