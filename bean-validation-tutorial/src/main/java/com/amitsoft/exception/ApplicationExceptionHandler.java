package com.amitsoft.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> invalidData(MethodArgumentNotValidException e) {
		Map<String, String> errors = new HashMap<>();

		// ---Just this one or two line of code will provide all field errors with
		// prpper message
		e.getBindingResult().getFieldErrors().forEach(exc -> {
			errors.put(exc.getField(), exc.getDefaultMessage());

		});
		return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, Object>> userNotFound(UserNotFoundException e) {
		Map<String, Object> error = new HashMap<>();
		error.put("message", e.getLocalizedMessage());
		error.put("status", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Map<String, Object>>(error, HttpStatus.NOT_FOUND);
	}

}
