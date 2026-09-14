package com.dcl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcl.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	Optional<Product> findByProductName(String productName);
}
