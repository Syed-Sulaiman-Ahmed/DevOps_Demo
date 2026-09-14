package com.dcl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(exception = AppException.class)
	public ResponseEntity<?> handleException(AppException exception){
		return new ResponseEntity<>(exception.getMessage(), exception.getHttpStatus());
	}
	
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<?> handleException(){
		Exception exception =new Exception();
		return new ResponseEntity<>("Something went wrong!!",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
