package lt.codeacademy.notebookrest.repository;

import lt.codeacademy.notebookrest.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
