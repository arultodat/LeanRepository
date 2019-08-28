package com.example.controller;

import java.util.List;

import javax.management.relation.RelationTypeNotFoundException;
import javax.validation.Valid;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.example.model.Note;
import com.example.repository.NoteRepository;

@RestController
@RequestMapping("/api")

public class NoteController {
	@Autowired	
	NoteRepository noteRepository;
	
	//select
	@GetMapping("/notes")
	public List<Note> getAllList(){
		return noteRepository.findAll();
	}
	
	//create
	@PostMapping("/notes")
	public Note createNote(@Valid @RequestBody Note notes)
	{
		return noteRepository.save(notes);
	}
	
	//search
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable(value = "id")Long notesId) throws RelationTypeNotFoundException
	{
		
		return noteRepository.findById(notesId).orElseThrow(()-> new RelationTypeNotFoundException ());
	}

	//update
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value = "id")Long notesId, @Valid @RequestBody Note noteDetails)
{
	Note notes = noteRepository.findById(notesId)
			.orElseThrow(()-> new ResourceAccessException("Notes"));
			notes.setTitle(noteDetails.getTitle());
			notes.setDescription(noteDetails.getDescription());
			
			Note updateNote = noteRepository.save(notes);
			return updateNote;
}

//Delete

@DeleteMapping("/notes/{id}")
public ResponseEntity<?> deleteNote(@PathVariable(value="id")Long notesId)
{
	Note notes = noteRepository.findById(notesId).orElseThrow(()-> new ResourceClosedException("Notes"));
	noteRepository.delete(notes);
	return ResponseEntity.ok().build();
}
}
