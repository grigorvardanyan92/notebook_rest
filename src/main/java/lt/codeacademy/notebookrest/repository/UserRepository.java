package lt.codeacademy.notebookrest.repository;

import lt.codeacademy.notebookrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> getByUsername(String username);
}
