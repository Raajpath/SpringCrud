package com.example.crud.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.crud.model.ExceptionResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler({UserNameNotFoundException.class})
	public ResponseEntity<ExceptionResponse> userNameNotFoundException(final UserNameNotFoundException userNameNotFoundException){
		return (ResponseEntity<ExceptionResponse>) new ResponseEntity((Object) new ExceptionResponse(
				userNameNotFoundException.getMessage(), LocalDateTime.now(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
		
	}

	@SuppressWarnings("unchecked")
	@ExceptionHandler({UserIdNotFoundException.class})
	public ResponseEntity<ExceptionResponse> userIdNotFoundException(final UserIdNotFoundException userIdNotFoundException){
		return (ResponseEntity<ExceptionResponse>) new ResponseEntity((Object) new ExceptionResponse(
				userIdNotFoundException.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler({EmailIdNotFoundException.class})
	public ResponseEntity<ExceptionResponse> EmailIdNotFoundException(final EmailIdNotFoundException emailIdNotFoundException){
		return (ResponseEntity<ExceptionResponse>) new ResponseEntity((Object) new ExceptionResponse(
				emailIdNotFoundException.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getFieldErrors().forEach((error) -> {
	        String fieldName = error.getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
}
