package com.dcl.request;

import lombok.Data;

@Data
public class AddProductRequest {
	
    private String productName;
	
	private Double price;
	
	private String category;

}
