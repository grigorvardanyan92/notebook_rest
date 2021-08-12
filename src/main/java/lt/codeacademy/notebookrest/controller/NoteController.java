package lt.codeacademy.notebookrest.controller;

import lt.codeacademy.notebookrest.entity.Note;
import lt.codeacademy.notebookrest.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        // if (principal.id == note.getUser.getId)?? TODO
        return noteService.save(note);
    }

    @GetMapping("/{id}")
    public Note getUncompletedNote(@PathVariable Long id) {
        return noteService.getUncompletedNoteByUserId(id);
    }

    @PutMapping("/{id}")// ?? TODO
    public Note update(@PathVariable Long id, @RequestBody Note note) {
        return noteService.save(note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteService.deleteById(id);
    }

    @GetMapping("/uncompleted")
    public List<Note> getUncompletedNotes() {
        return noteService.getAllUncompletedByUserId(1L);
    }

    @GetMapping("/home")
    public List<Note> getHomeNotes() {
        return noteService.getAllByUserIdAndCategoryName(1L, "home");
    }

    @GetMapping("/work")
    public List<Note> getWorkNotes() {
        return noteService.getAllByUserIdAndCategoryName(1L, "work");
    }

    @GetMapping("/studies")
    public List<Note> getStudiesNotes() {
        return noteService.getAllByUserIdAndCategoryName(1L, "studies");
    }

    @GetMapping("/personal")
    public List<Note> getPersonalNotes() {
        return noteService.getAllByUserIdAndCategoryName(1L, "personal");
    }
}
