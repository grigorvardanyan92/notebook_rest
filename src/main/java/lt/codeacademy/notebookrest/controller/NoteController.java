package lt.codeacademy.notebookrest.controller;

import lt.codeacademy.notebookrest.dto.response.NoteResponse;
import lt.codeacademy.notebookrest.entity.Note;
import lt.codeacademy.notebookrest.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public NoteResponse create(@RequestBody Note note) {
        return new NoteResponse(noteService.save(note));
    }

    @GetMapping("/{id}")
    public NoteResponse getUncompletedNote(@PathVariable Long id) {
        return new NoteResponse(noteService.getUncompletedNoteById(1L));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Note note) {
        noteService.save(note);
    }

    @GetMapping("/{note}/completed")
    public void setCompleted(@PathVariable Note note) {
        note.setIsCompleted(true);
        noteService.save(note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteService.deleteById(id);
    }

    @GetMapping("/uncompleted")
    public List<NoteResponse> getUncompletedNotes() {
        return noteService.getAllUncompletedByUserId(1L).stream().map(NoteResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/home")
    public List<NoteResponse> getHomeNotes() {
        return noteService.getAllByUserIdAndCategoryName(1L, "home")
                .stream().map(NoteResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/work")
    public List<NoteResponse> getWorkNotes() {
        return noteService.getAllByUserIdAndCategoryName(1L, "work")
                .stream().map(NoteResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/studies")
    public List<NoteResponse> getStudiesNotes() {
        return noteService.getAllByUserIdAndCategoryName(1L, "studies")
                .stream().map(NoteResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/personal")
    public List<NoteResponse> getPersonalNotes() {
        return noteService.getAllByUserIdAndCategoryName(1L, "personal")
                .stream().map(NoteResponse::new).collect(Collectors.toList());
    }
}
