package com.devsuperior.d001dsclient.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.d001dsclient.services.exceptions.DatabaseException;
import com.devsuperior.d001dsclient.services.exceptions.ResourceNotFoundException;

@ControllerAdvice					// vai permitir que essa classe intercepte alguma exceção que ocorrer na camada de RESOURCE controlador REST, ele que vai tratar aqui agora
public class ResourceExceptionHandle {

	@ExceptionHandler(ResourceNotFoundException.class)   // nome da exceção
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
				
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Resorce not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(DatabaseException.class)   // nome da exceção
	public ResponseEntity<StandardError> databae(DatabaseException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Database exception");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}	
}
