package com.example.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.ecommerce.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query(value = "select * from categories", nativeQuery = true)
	public List<Category> getCategories();

	@Query(value = "select * from categories where name = ?1", nativeQuery = true)
	public Category getId(@Param("name") String title);

	@Query(value = "select * from categories where id =?1", nativeQuery = true)
	public Category getReferenceById(Integer id);

}
