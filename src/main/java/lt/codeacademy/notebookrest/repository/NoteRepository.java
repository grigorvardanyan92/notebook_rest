package lt.codeacademy.notebookrest.repository;

import lt.codeacademy.notebookrest.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    public Optional<Note> getNoteByIdAndIsCompletedIsFalse(Long id);
    public List<Note> getAllByUserIdAndIsCompletedFalse(Long id);
    public List<Note> getAllByUserIdAndCategoryNameAndIsCompletedIsFalse(Long id, String CategoryName);
    public List<Note> getAllByUserUsernameAndIsCompletedIsTrue(String username);
}
