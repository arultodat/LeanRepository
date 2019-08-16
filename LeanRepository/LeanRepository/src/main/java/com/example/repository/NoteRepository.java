package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

	
}
