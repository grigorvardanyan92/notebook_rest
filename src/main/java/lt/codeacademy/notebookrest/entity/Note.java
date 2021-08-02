package lt.codeacademy.notebookrest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String text;
    Boolean isCompleted = false;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
