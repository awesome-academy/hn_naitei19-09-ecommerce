package com.example.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.ecommerce.dao.CategoryRepository;
import com.example.ecommerce.dao.ProductRepository;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;

@Controller
public class HomeController {
	/* Autowired */
	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ProductRepository productRepo;

	@GetMapping(value = { "/", "/home" })
	public String firstHomeView(Model m) {
		List<Product> products = this.productRepo.getProductsSortedByBuyCount();
		List<Category> categories = this.categoryRepo.getCategories();
		m.addAttribute("categories", categories);
		m.addAttribute("products", products);
		return "index.html";
	}
	
	@GetMapping("/search")
	public String searchProducts(@RequestParam(value = "category", required = false) Integer categoryType,
			@RequestParam(name = "query", required = false) String query) {
		return "search_product";
	}
	
	@GetMapping("/showProduct")
	public String productDetail(@RequestParam(name = "product_id", required = false) Integer id, Model m) {
		Product product = this.productRepo.getReferenceById(id);
		m.addAttribute("product", product);
		return "show_product";
	}
		

}
