package com.buyproducts.store.domain.form;

import java.util.List;

import com.buyproducts.store.model.postgre.Category;
import com.buyproducts.store.model.postgre.Product;

import lombok.Data;

@Data
public class ProductContentForm {
	
	private List<Category> categories;
	
	private List<Product> products;

}
