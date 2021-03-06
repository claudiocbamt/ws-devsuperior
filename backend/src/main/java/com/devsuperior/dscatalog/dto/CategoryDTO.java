package com.devsuperior.dscatalog.dto;
import com.devsuperior.dscatalog.entities.category;
import java.io.Serializable;


public class CategoryDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Long  Id;	
	private String Name;
	
	
	public CategoryDTO(){
		
	}
	
	public CategoryDTO(Long id, String name) {
		super();
		Id = id;
		Name = name;
	}
	
	public CategoryDTO(category entidade) {
		
		this.Id = entidade.getId();
		this.Name = entidade.getName();
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryDTO other = (CategoryDTO) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
