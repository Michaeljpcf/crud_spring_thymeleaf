package com.crud.crud.services;

import java.util.List;

import com.crud.crud.entities.Product;

public interface ProductServices {

	public List<Product> listProducts();

	public Product createProduct(Product product);

	public Product getProductById(Long id);

	public Product updateProduct(Product product);

	public void deleteProduct(Long id);
}
