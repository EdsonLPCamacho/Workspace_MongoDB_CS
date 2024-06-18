package com.workspacemongodbcs.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.workspacemongodbcs.services.exception.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> notFound(NotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(),
				status.value(), "Not Foud!", e.getMessage(),request.getRequestURI()); 
		
		return ResponseEntity.status(status).body(err);
				
	}
}
