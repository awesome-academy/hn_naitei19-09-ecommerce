package com.example.ecommerce.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "select * from products", nativeQuery = true)
	public List<Product> getProducts();

	@Query(value = "select * from products where id =?1", nativeQuery = true)
	public Product getReferenceById(Integer id);

	@Query(value = "SELECT * FROM products ORDER BY buy_count DESC LIMIT 8", nativeQuery = true)
	public List<Product> getProductsSortedByBuyCount();

	@Query(value = "SELECT p.* FROM products p JOIN categories c ON p.category_id = c.id WHERE c.name = ?1", nativeQuery = true)
	public List<Product> getProductsByCategory(String categoryName);

	@Query(value = "SELECT * FROM products WHERE LOWER(name) LIKE  CONCAT('%', :query, '%')", nativeQuery = true)
	List<Product> searchAllCategories(@Param("query") String query);

	@Query(value = "SELECT * FROM products WHERE category_id = :categoryId AND LOWER(name) LIKE %:query%", nativeQuery = true)
	List<Product> searchByCategory(@Param("categoryId") Integer categoryId, @Param("query") String query);

}
