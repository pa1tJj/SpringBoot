package com.jone.coffee.dto;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerErrors {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleValidationErrors(MethodArgumentNotValidException ex) {
		List<String> details = ex.getBindingResult()
	            .getFieldErrors()
	            .stream()
	            .map(error -> error.getField() + ": " + error.getDefaultMessage())
	            .toList();

	    // Tạo object trả về
	    ErrorMessage errorMessage = new ErrorMessage();
	    errorMessage.setError("Validation failed");
	    errorMessage.setDetail(details);

	    // Trả về JSON lỗi
	    return ResponseEntity.badRequest().body(errorMessage);
	}
}
