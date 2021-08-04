package lt.codeacademy.notebookrest.repository;

import lt.codeacademy.notebookrest.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Optional<Category> getByName(String name);
}
