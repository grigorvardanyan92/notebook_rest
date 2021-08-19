package lt.codeacademy.notebookrest.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lt.codeacademy.notebookrest.entity.Note;

@Data
public class NoteResponse {

    private long id;
    private String text;
    private String category;
    private String userName;

    public NoteResponse(Note note) {
        this.id = note.getId();
        this.text = note.getText();
        this.category = note.getCategory().getName();
        this.userName = note.getUser().getUsername();
    }
}
