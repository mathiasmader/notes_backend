package com.example.notes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.notes.exception.NoteNotFoundException;
import com.example.notes.model.Note;
import com.example.notes.repository.NotesRepository;

@Service
public class NoteServiceImplementation implements NoteService {

	// DAO Object

	@Autowired
	private NotesRepository noteRepository;

	// Database interaction

	@Override
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}

	@Override
	public Note getNote(Long noteId) {

		if (noteRepository.existsById(noteId))
			return noteRepository.getReferenceById(noteId);
		else
			throw new NoteNotFoundException();
	}

	@Override
	public Note addNote(Note note) {
		note.setId(null);
		return noteRepository.save(note);
	}

	@Override
	public Note updateNote(Long noteId, Note note) {
		if (noteRepository.existsById(noteId)) {
			note.setId(noteId);
			return noteRepository.save(note);
		} else {
			throw new NoteNotFoundException();
		}
	}

	@Override
	public void deleteNote(Long noteId) {
		if (noteRepository.existsById(noteId))
			noteRepository.deleteById(noteId);
		else
			throw new NoteNotFoundException();
	}

	@Override
	public void deleteAllNotes() {
		noteRepository.deleteAll();
	}
}
