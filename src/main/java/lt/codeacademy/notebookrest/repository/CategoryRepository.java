package lt.codeacademy.notebookrest.repository;

import lt.codeacademy.notebookrest.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
