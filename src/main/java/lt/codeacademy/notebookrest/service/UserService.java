package lt.codeacademy.notebookrest.service;

import lt.codeacademy.notebookrest.entity.User;
import lt.codeacademy.notebookrest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllWithRoleUser() {
        return userRepository.getAllByRoleName("ROLE_USER");
    }

    public User getByUsername(String username) {
        return userRepository.getByUsername(username).orElse(null);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
