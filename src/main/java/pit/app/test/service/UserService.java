package pit.app.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.app.test.entity.User;
import pit.app.test.repository.UserRepository;
import pit.app.test.service.impl.UserServiceImpl;

import java.util.List;

@Service
public class UserService implements UserServiceImpl {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    @Override
    public int updateUser(String firstName, String lastName, String email, String password, String phone, long id) {
        return userRepository.updateUser(firstName, lastName, email, password, phone, id);
    }
}
