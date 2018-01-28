package com.buyproducts.store.repository.postgre;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.buyproducts.store.model.postgre.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findByParentCategoryNullOrderById(); 

}
