package com.buyproducts.store.model.postgre;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String title;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Category parentCategory;
	
	@OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
	private List<Category> subCategories;
	
}
