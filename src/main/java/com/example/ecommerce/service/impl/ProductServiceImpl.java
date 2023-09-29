package com.example.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dao.ProductRepository;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {

		return productRepository.getProducts();
	}

	@Override
	public List<Product> getProductsSortedByBuyCount() {

		return productRepository.getProductsSortedByBuyCount();
	}

	@Override
	public List<Product> getProductsByCategory(String category) {

		return productRepository.getProductsByCategory(category);
	}

	@Override
	public List<Product> searchAllCategories(String query) {
		return productRepository.searchAllCategories(query);
	}

	@Override
	public List<Product> searchByCategory(Integer categoryId, String query) {
		return productRepository.searchByCategory(categoryId, query);
	}

	@Override
	public Product getReferenceById(Integer id) {
		return productRepository.getReferenceById(id);
	}
}
