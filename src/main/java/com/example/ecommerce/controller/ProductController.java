package com.example.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.ProductService;

@Controller("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("categories/{categoryName}/products")
	public String index(@PathVariable(name = "categoryName") String categoryName, Model model,
			HttpServletResponse response) throws IOException {
		Category category = this.categoryService.getId(categoryName);
		if (category == null) {
			response.sendRedirect("/404-page");
			String errorMessage = "Không tìm thấy sản phẩm";
			model.addAttribute("errorMessage", errorMessage);
			return "error";
		}
		List<Product> products = this.productService.getProductsByCategory(categoryName);
		model.addAttribute("products", products);
		return "products/index";
	}

	@GetMapping("/{product_id}")
	public String show(@PathVariable(name = "product_id") Integer id, Model m, HttpServletResponse response)
			throws IOException {
		Product product = this.productService.getReferenceById(id);
		if (product == null) {
			response.sendRedirect("/404-page");
			String errorMessage = "Không tìm thấy sản phẩm";
			m.addAttribute("errorMessage", errorMessage);
			return "error";
		}

		m.addAttribute("product", product);
		return "products/show";
	}
	
	@GetMapping("/search?category={category_id}&keyword={keyword}")
	public String search(@RequestParam(value = "category_id") Integer category, @RequestParam(value = "keyword") String keyword, Model model) {
		List<Product> products;
	    if (category == null || category == -1) {
	        products = this.productService.searchAllCategories(keyword);
	    } else {	      
	        Category selectedCategory = this.categoryService.getReferenceById(category);
	        if (selectedCategory == null) {	          
	            return "error";
	        }
	        products = this.productService.searchByCategory(category, keyword );
	    }
	    model.addAttribute("products", products);	    
		return "products/search";
	}

}
