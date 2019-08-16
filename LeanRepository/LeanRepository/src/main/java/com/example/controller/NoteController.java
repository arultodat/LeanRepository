package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.omg.CORBA.PUBLIC_MEMBER;
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

import ch.qos.logback.core.pattern.parser.Node;

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
	public Note createNote(@Valid @RequestBody Note note)
	{
		return noteRepository.save(note);
	}
	
	//search
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable(value = "id")Long noteId)
	{
		
		return noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException ("Note","id",noteId));
	}

	//update
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value = "id")Long noteId), @Valid @RequestBody Note noteDetails)
{
	Note note = noteRepository.findById(NodeId)
			.orElseThrow()-> new ResourceAccessException("Note","id",noteId));
			note.setTitle(noteDetails.getTitle());
			note.setDescription(noteDetails.getDescription());
			
			Note updateNote = noteRepository.save(note);
			return updateNote;
}

//Delete

@DeleteMapping("/notes/{id}")
public ResponseEntity<?> deleteNote(@PathVariable(value="id")Long noteId)
{
	Note note = noteRepository.findById(noteId).orElseThrow(()-> new ResourceNoteFoundException("Noote","id", noteId));
	noteRepository.delete(note);
	return ResponseEntity.ok().build();
}
}
