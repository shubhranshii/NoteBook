package com.example.demo.service;

import com.example.demo.dao.NoteDao;
import com.example.demo.model.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteDao notedao;

    public NoteService(NoteDao notedao) {
        this.notedao = notedao;
    }

    public List<Note> getNotes() {
        return notedao.getNotes();
    }

    public String createNote(Note note) {
        notedao.save(note);
        return "created";
    }

    public String deleteNote(Integer id) {
        notedao.deleteById(id);
        return "deleted";
    }

    public Note editNote(Integer id, Note updatedNote) {
        Optional<Note> optionalNote = notedao.findById(id);
        if (optionalNote.isPresent()) {
            Note existingNote = optionalNote.get();
            existingNote.setTitle(updatedNote.getTitle());
            existingNote.setContent(updatedNote.getContent());
            return notedao.save(existingNote);
        } else {
            throw new RuntimeException("Note not found with id " + id);
        }
    }
}
