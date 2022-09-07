package com.example.notes.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Messages to return - imported from application.properties
	
	@Value(value = "${data.exception.message1}")
	private String message1;

	@Value(value = "${data.exception.message2}")
	private String message2;

	/*
	 * Methods to catch global Exceptions and return the corresponding
	 * ResponseEntity<String>
	 * 
	 */

	@ExceptionHandler(value = NoteNotFoundException.class)
	public ResponseEntity<String> noteNotFoundException(NoteNotFoundException noteNotFoundException) {
		return new ResponseEntity<String>(message1, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoteAlreadyExistsException.class)
	public ResponseEntity<String> noteNotFoundException(NoteAlreadyExistsException noteNotFoundException) {
		return new ResponseEntity<String>(message2, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> databaseConnectionFailsException(Exception exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}