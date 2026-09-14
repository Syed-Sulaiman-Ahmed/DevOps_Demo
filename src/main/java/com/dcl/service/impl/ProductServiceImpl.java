package com.dcl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dcl.dto.ProductDto;
import com.dcl.entity.Product;
import com.dcl.exception.AppException;
import com.dcl.repository.ProductRepo;
import com.dcl.request.AddProductRequest;
import com.dcl.request.UpdateProductRequest;
import com.dcl.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo prepo;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public ProductDto addProduct(AddProductRequest request) {
		Product exists=prepo.findByProductName(request.getProductName()).orElse(null);
		if(exists!=null) {
			throw new AppException("Product Already Exists!!!", HttpStatus.FOUND);
		}
		
		Product p=mapper.map(request, Product.class);
		p=prepo.save(p);
		
		ProductDto dto=mapper.map(p, ProductDto.class);
		
		return dto;
	}

	@Override
	public ProductDto updateProduct(UpdateProductRequest request) {
		
		Product product=prepo.findByProductName(request.getProductName()).orElse(null);
		
		if(product==null) {
			throw new AppException("Product Not Found!!", HttpStatus.NOT_FOUND);
		}
		
		mapper.map(request, Product.class);
		product=prepo.save(product);
		
		ProductDto dto=mapper.map(product, ProductDto.class);
		
		return dto;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		
		List<Product> productList=prepo.findAll();
		
		return productList.stream()
				.map(product -> mapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteProductById(Integer productId) {
		
		Product p=prepo.findById(productId).orElse(null);
		
		if(p==null) {
			throw new AppException("Product Not Found!!", HttpStatus.NOT_FOUND);
		}
		
		prepo.deleteById(productId);
		
	}

	@Override
	public ProductDto getProductById(Integer productId) {

		Product p=prepo.findById(productId).orElse(null);
		if(p==null) {
			throw new AppException("Product Not Found!!", HttpStatus.NOT_FOUND);
		}
		
		ProductDto dto=mapper.map(p, ProductDto.class);
		return dto;
	}
	
	

}
