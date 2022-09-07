package com.example.notes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.notes.model.Note;
import com.example.notes.service.NoteService;

@RestController
@RequestMapping("/note")
@CrossOrigin
public class NotesController {

	// Service Object to delegate requests to the Database 

	@Autowired
	private NoteService noteService;

	// GET - Search for Notes in the Database and return them

	@GetMapping
	public ResponseEntity<List<Note>> getAllNotes() {
		return new ResponseEntity<List<Note>>(noteService.getAllNotes(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Note> getNote(@PathVariable("id") Long id) {
		return new ResponseEntity<Note>(noteService.getNote(id), HttpStatus.OK);
	}

	// POST - Add a single note to the database

	@PostMapping
	public ResponseEntity<Note> addNote(@RequestBody Note note) {
		return new ResponseEntity<Note>(noteService.addNote(note), HttpStatus.CREATED);
	}

	// PULL - Change existing notes

	@PutMapping(value = "/{id}")
	public ResponseEntity<Note> updateNote(@RequestBody Note note, @PathVariable("id") Long id) {
		return new ResponseEntity<Note>(noteService.updateNote(id, note), HttpStatus.OK);
	}

	// DELETE - Delete notes

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteNote(@PathVariable("id") Long id) {
		noteService.deleteNote(id);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteAllNotes() {
		noteService.deleteAllNotes();
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

}
