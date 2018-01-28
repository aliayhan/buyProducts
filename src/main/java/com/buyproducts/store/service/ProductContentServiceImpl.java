package com.buyproducts.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.buyproducts.store.model.postgre.Category;
import com.buyproducts.store.model.postgre.Product;
import com.buyproducts.store.repository.postgre.CategoryRepository;
import com.buyproducts.store.repository.postgre.ProductRepository;

@Service
public class ProductContentServiceImpl implements ProductContentService {
	
	private static final int MAX_PAGE_SIZE = 5;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Category> getMainCategories() {
		return categoryRepository.findByParentCategoryNullOrderById();
	}

	@Override
	public List<Product> getProductsByCategoryId(long categoryId, int pageNo) {
		Category category = categoryRepository.findOne(categoryId);
		return productRepository.queryByCategoryOrderById(category, new PageRequest(pageNo, MAX_PAGE_SIZE)).getContent();
	}
	
	public Integer toInt(String number) {
		try {
			return Integer.valueOf(number);
		} catch (Exception ex) {
			return null;
		}
	}

}
