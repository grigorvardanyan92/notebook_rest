package lt.codeacademy.notebookrest.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lt.codeacademy.notebookrest.entity.Note;

@Data
@NoArgsConstructor
public class NoteResponse {

    private String text;
    private String category;
    private String userName;

    public NoteResponse(Note note) {
        this.text = note.getText();
        this.category = note.getCategory().getName();
        this.userName = note.getUser().getUsername();
    }
}
