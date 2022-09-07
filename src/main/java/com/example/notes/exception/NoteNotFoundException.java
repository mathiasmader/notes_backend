package com.example.notes.exception;

public class NoteNotFoundException extends RuntimeException {

	private String message;

	public NoteNotFoundException() {
	}

	public NoteNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
