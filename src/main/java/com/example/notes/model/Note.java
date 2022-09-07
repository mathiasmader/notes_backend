package com.example.notes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Model represents database table object

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@Column(nullable = false)
	private String title;

	private String text;

	public Note() {
	}

	// ID

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	// Title

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// Text

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
