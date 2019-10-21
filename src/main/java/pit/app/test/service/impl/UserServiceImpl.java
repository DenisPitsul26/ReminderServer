package pit.app.test.service.impl;

import pit.app.test.entity.User;

import java.util.List;

public interface UserServiceImpl {
    List<User> getAllUser();

    User getUserById(long id);

    User saveUser(User user);

    void deleteUser(long id);

    User getUserByEmailAndPassword(String email, String password);

    int updateUser(String firstName, String lastName, String email, String password, String phone, long id);
}
