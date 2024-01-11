package com.crud.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crud.entities.Product;
import com.crud.crud.repositories.ProductRepository;

@Service
public class ProductServicesImpl implements ProductServices {
	
	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> listProducts() {
		return repository.findAll();
	}

	@Override
	public Product createProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}

}
