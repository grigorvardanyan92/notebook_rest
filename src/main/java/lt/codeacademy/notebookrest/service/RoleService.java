package lt.codeacademy.notebookrest.service;

import lt.codeacademy.notebookrest.entity.Role;
import lt.codeacademy.notebookrest.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role getByName(String name) {
        return roleRepository.getByName(name).orElse(null);
    }
}
