package com.devsuperior.dscatalog.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.category;
@Repository
public interface CategoryRepository extends JpaRepository <category,Long > {
	

}
