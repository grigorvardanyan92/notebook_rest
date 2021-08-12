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

    public Note getNote(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note getUncompletedNoteByUserId(Long id) {
        Note note = getNote(id);
        return note != null && !note.getIsCompleted() ? note : null;
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

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
