package com.dcl.service;

import java.util.List;

import com.dcl.dto.ProductDto;
import com.dcl.request.AddProductRequest;
import com.dcl.request.UpdateProductRequest;

public interface ProductService {

	ProductDto addProduct(AddProductRequest request);
	
	ProductDto updateProduct(UpdateProductRequest request);
	
	ProductDto getProductById(Integer productId);
	
	List<ProductDto> getAllProducts();
	
	void deleteProductById(Integer productId);
}
