package lt.codeacademy.notebookrest.service;

import lt.codeacademy.notebookrest.entity.Note;
import lt.codeacademy.notebookrest.repository.NoteRepository;
import org.springframework.stereotype.Service;

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

    public List<Note> getAllUncompletedByUserId(Long id) {
        return noteRepository.getAllByUserIdAndIsCompletedFalse(id);
    }

    public List<Note> getAllCompletedByUserId(Long id) {
        return noteRepository.getAllByUserIdAndIsCompletedTrue(id);
    }

    public List<Note> getAllByUserIdAndCategoryName(Long id, String category) {
        return noteRepository.getAllByUserIdAndCategoryName(id, category);
    }

    public void delete(Note note) {
        noteRepository.delete(note);
    }
}
