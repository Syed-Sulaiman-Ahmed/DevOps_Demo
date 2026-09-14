package com.dcl.request;

import lombok.Data;

@Data
public class UpdateProductRequest {

    private String productName;
	
	private Double price;
	
	private String category;
	
}

