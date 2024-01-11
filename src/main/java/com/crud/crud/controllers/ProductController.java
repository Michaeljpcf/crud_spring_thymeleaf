package com.crud.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.crud.entities.Product;
import com.crud.crud.services.ProductServices;

@Controller
public class ProductController {

	@Autowired
	private ProductServices services;

	@GetMapping({"/products","/"})
	public String listProducts(Model model) {
		model.addAttribute("product", services.listProducts());
		return "product";
	}

	@GetMapping("/products/new")
	public String getFormulario(Model model){
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}

	@PostMapping("/products")
	public String create(@ModelAttribute("product") Product product) {
		services.createProduct(product);
		return "redirect:/products";
	}

	@GetMapping("/products/update/{id}")
	public String getFromUpdate(@PathVariable Long id, Model model) {
		model.addAttribute("product", services.getProductById(id));
		return "update_product";
	}

	@PostMapping("/products/{id}")
	public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Product product, Model model) {
		Product productExists = services.getProductById(id);
		productExists.setIdproducts(id);
		productExists.setName(product.getName());
		productExists.setPrice(product.getPrice());
		productExists.setDescription(product.getDescription());

		services.updateProduct(productExists);
		return "redirect:/products";
	}

	@GetMapping("/products/{id}")
	public String deleteProduct(@PathVariable Long id) {
		services.deleteProduct(id);
		return "redirect:/products";
	}
}