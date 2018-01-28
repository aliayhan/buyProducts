package com.buyproducts.store.repository.postgre;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.buyproducts.store.model.postgre.Category;
import com.buyproducts.store.model.postgre.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
	
	Page<Product> queryByCategoryOrderById(Category category, Pageable pageable); 

}
