package com.dcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.dto.ProductDto;
import com.dcl.request.AddProductRequest;
import com.dcl.request.UpdateProductRequest;
import com.dcl.response.ApiResponse;
import com.dcl.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody AddProductRequest request){	
		ProductDto dto=pservice.addProduct(request);
		return ResponseEntity.ok(new ApiResponse<>("Product Added Successfully!!", dto, HttpStatus.OK));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody UpdateProductRequest request){
		ProductDto dto=pservice.updateProduct(request);
		return ResponseEntity.ok(new ApiResponse<>("Product Updated Successfully!!", dto, HttpStatus.OK));
	}
	
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable Integer productId){
		ProductDto dto=pservice.getProductById(productId);
		ApiResponse response=new ApiResponse<>("Product found!!", dto, HttpStatus.OK);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllProducts(){
		List<ProductDto> dto=pservice.getAllProducts();
		return ResponseEntity.ok(new ApiResponse<>("List of all Products!!", dto, HttpStatus.OK));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
		pservice.deleteProductById(productId);
		return ResponseEntity.ok(new ApiResponse<>("Product Deleted Successfully!!", null, HttpStatus.OK));
	}

}
