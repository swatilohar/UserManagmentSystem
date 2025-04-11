package com.ExceptionHandling;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<?> noSuchElementExceptionhandling(NoSuchElementException e){
		
		return new ResponseEntity("Id not present please enter valid id.",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public ResponseEntity<?> EmptyResultDataAccessExceptionHanle(EmptyResultDataAccessException e){
		
		return new ResponseEntity("Id not present please enter valid id.",HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> validationExceptionHandling(MethodArgumentNotValidException e){
		
		return new ResponseEntity(e.getFieldError().getDefaultMessage() , HttpStatus.BAD_REQUEST);
	}

}
