package lt.codeacademy.notebookrest.repository;

import lt.codeacademy.notebookrest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Optional<Role> getByName(String name);
}
