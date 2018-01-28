package com.buyproducts.store.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buyproducts.store.domain.form.ProductContentForm;
import com.buyproducts.store.service.ProductContentService;

@Controller
public class PageController {
	
	private static final Logger LOGGER = Logger.getLogger(PageController.class);
	
	@Autowired
	private ProductContentService productContentService;

	@RequestMapping(value = {"/", "/login"})
	public String login() {
		return "login";
	}

	@RequestMapping(value = {"/content"})
	public String content(final ProductContentForm productContentForm) {
		try {
			productContentForm.setCategories(productContentService.getMainCategories());
			return "content";
		} catch (Exception ex) {
			LOGGER.error("Error on content", ex);
			return "400";
		}
	}
	
	@RequestMapping(value = {"/contentAndProducts"})
	public String contentAndProducts(final ProductContentForm productContentForm, @RequestParam(name = "category") String categoryParam, @RequestParam(name = "page") String pageParam) {
		try {
			long categoryId = Long.valueOf(categoryParam);
			int pageNo = Integer.valueOf(pageParam);
			productContentForm.setCategories(productContentService.getMainCategories());
			productContentForm.setProducts(productContentService.getProductsByCategoryId(categoryId, pageNo));
			return "content";
		} catch (Exception ex) {
			LOGGER.error("Error on contentAndProducts", ex);
			return "400";
		}		
	}

	@RequestMapping(value = "/403")
	public String Error403() {
		return "403";
	}
	
}