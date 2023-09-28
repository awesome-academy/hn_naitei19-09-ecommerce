package com.example.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value = "select * from products", nativeQuery = true)
	public List<Product> getProducts();
	
	@Query(value = "SELECT * FROM products ORDER BY buy_count DESC LIMIT 8", nativeQuery = true)
	public List<Product> getProductsSortedByBuyCount();
}