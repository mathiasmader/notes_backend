package com.example.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.notes.model.Note;

/**
 * Spring uses this interface to persist Note objects in relational databases.
 */
@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {
}
