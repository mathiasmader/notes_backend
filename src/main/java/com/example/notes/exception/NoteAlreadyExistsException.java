package com.example.notes.exception;

public class NoteAlreadyExistsException extends RuntimeException {
	private String message;

	public NoteAlreadyExistsException() {
	}

	public NoteAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
}
