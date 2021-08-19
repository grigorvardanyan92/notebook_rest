package lt.codeacademy.notebookrest.service;

import lt.codeacademy.notebookrest.entity.Note;
import lt.codeacademy.notebookrest.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public Note getUncompletedNoteById(Long id) {
        return noteRepository.getNoteByIdAndIsCompletedIsFalse(id).orElse(null);
    }

    public List<Note> getAllUncompletedByUserId(Long id) {
        return noteRepository.getAllByUserIdAndIsCompletedFalse(id);
    }

    public List<Note> getAllCompletedByUsername(String username) {
        return noteRepository.getAllByUserUsernameAndIsCompletedIsTrue(username);
    }

    public List<Note> getAllByUserIdAndCategoryName(Long id, String category) {
        return noteRepository.getAllByUserIdAndCategoryNameAndIsCompletedIsFalse(id, category);
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
