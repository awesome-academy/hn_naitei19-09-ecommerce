package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.model.Category;

public interface CategoryService {

	public List<Category> getCategories();

	public Category getReferenceById(Integer id);

	public Category getId(String categoryName);

}
