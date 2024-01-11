package com.crud.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.crud.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
