package lt.codeacademy.notebookrest.repository;

import lt.codeacademy.notebookrest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Optional<Role> getByName(String name);
}
