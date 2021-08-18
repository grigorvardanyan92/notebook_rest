package lt.codeacademy.notebookrest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Note> notes;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
