package com.example.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Product;

@Service
public interface ProductService {
	 	

		List<Product> getProducts();
		
		List<Product> getProductsSortedByBuyCount();
		
		
		List<Product> getProductsByCategory(String category);

		
	    List<Product> searchAllCategories(String query);

	  
	    List<Product> searchByCategory(Integer categoryId, String query);



}
