package com.example.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.ecommerce.dao.ProductRepository;
import com.example.ecommerce.model.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("/products")
	   public String showProductsByCategory(@RequestParam("category") String category, Model model) {
	        List<Product> products = this.productRepo.getProductsByCategory(category);
	        model.addAttribute("products", products);
	        return "product-list";    
	}
	
	

}
