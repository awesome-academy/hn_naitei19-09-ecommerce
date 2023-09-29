package com.example.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dao.CategoryRepository;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategories() {
		return categoryRepository.getCategories();
	}

	@Override
	public Category getId(String title) {
		return categoryRepository.getId(title);
	}

	public Category getReferenceById(Integer id) {
		return categoryRepository.getReferenceById(id);
	}
}
