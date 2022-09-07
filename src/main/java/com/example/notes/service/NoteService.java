package com.example.notes.service;

import java.util.List;

import com.example.notes.exception.NoteAlreadyExistsException;
import com.example.notes.exception.NoteNotFoundException;
import com.example.notes.model.Note;

/**
 * Interface used to represent the service class which calls the DAO
 */
public interface NoteService {

	public List<Note> getAllNotes();

	public Note getNote(Long noteId) throws NoteNotFoundException;

	public Note addNote(Note note);

	public Note updateNote(Long id, Note note) throws NoteNotFoundException, NoteAlreadyExistsException;

	public void deleteNote(Long noteId) throws NoteNotFoundException;

	public void deleteAllNotes();

}
