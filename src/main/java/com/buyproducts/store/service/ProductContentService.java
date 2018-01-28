package com.buyproducts.store.service;

import java.util.List;

import com.buyproducts.store.model.postgre.Category;
import com.buyproducts.store.model.postgre.Product;

public interface ProductContentService {

	List<Category> getMainCategories();
	
	List<Product> getProductsByCategoryId(long categoryId, int pageNo);
	
}
