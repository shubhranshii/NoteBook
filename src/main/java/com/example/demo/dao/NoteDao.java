package com.example.demo.dao;

import com.example.demo.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteDao extends JpaRepository <Note, Integer> {

    @Query("SELECT n FROM Note n")
    List<Note> getNotes();
}
