package lt.codeacademy.notebookrest.service;

import lt.codeacademy.notebookrest.entity.Category;
import lt.codeacademy.notebookrest.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getByName(String name) {
        return categoryRepository.getByName(name).orElse(null);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
