package com.example.demo.controller;

import com.example.demo.model.Note;
import com.example.demo.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/notes")
@RestController
public class NotesController {

    private final NoteService noteService;

    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping ("/new-note")
    public String createNote(@RequestBody Note note){
        return noteService.createNote(note);
    }

    @GetMapping("/get-notes")
    public List<Note> getNotes(){
        return noteService.getNotes();
    }

    @DeleteMapping("/delete-note")
    public String deleteNote(@RequestBody Integer id){
        return noteService.deleteNote(id);
    }

    @PostMapping("/edit-note/{id}")
    public Note editNote(@PathVariable Integer id, @RequestBody Note updatedNote){
        return noteService.editNote(id, updatedNote);
    }
}
