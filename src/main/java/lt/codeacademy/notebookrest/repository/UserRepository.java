package lt.codeacademy.notebookrest.repository;

import lt.codeacademy.notebookrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
