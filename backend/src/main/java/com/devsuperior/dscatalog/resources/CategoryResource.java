package com.devsuperior.dscatalog.resources;



import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.services.CategoryService;




@RestController
@RequestMapping(value = "/categories")


public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	@GetMapping
	
	public ResponseEntity <List<CategoryDTO>> BuscarTodos(){
		
		List<CategoryDTO> lista = service.BuscarTodos();
		
		
		//lista.add(new category(1L, "Books"));
		//lista.add(new category(2L,"Electronics"));
		
		return ResponseEntity.ok().body(lista);
	}

	
	
   @GetMapping(value= "/{id}")
	
	public ResponseEntity<CategoryDTO> BuscarPorId(@PathVariable("id")Long Id){
		
		CategoryDTO dto = service.BuscarPorId(Id);
		
		
		//lista.add(new category(1L, "Books"));
		//lista.add(new category(2L,"Electronics"));
		
		return ResponseEntity.ok().body(dto);
	}
   
   @PostMapping
	
  	public ResponseEntity<CategoryDTO> Inserir(@RequestBody CategoryDTO dto){
  		
  		 dto = service.Inserir(dto);
  		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
  				 .buildAndExpand(dto.getId()).toUri();
  				 
  		
  		
  		//lista.add(new category(1L, "Books"));
  		//lista.add(new category(2L,"Electronics"));
  		
  		return ResponseEntity.created(uri).body(dto);
  	}
   
   @PutMapping(value= "/{id}")
   public ResponseEntity<CategoryDTO> Atualizar(@PathVariable("id")Long Id, @RequestBody CategoryDTO dto){
	    dto = service.Atualizar( Id, dto);
		
		return ResponseEntity.ok().body(dto);
	}

   @DeleteMapping(value= "/{id}")
   public ResponseEntity<CategoryDTO> Excluir(@PathVariable("id")Long Id){
	    service.Excluir( Id);
		
		return ResponseEntity.noContent().build();
	}

}
   

