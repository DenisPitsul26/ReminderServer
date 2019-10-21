package pit.app.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pit.app.test.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    User findUserByEmailAndPassword(String email, String password);

    @Modifying
    @Transactional
    @Query("update User u set u.firstName = ?1, u.lastName = ?2, u.email = ?3, u.password = ?4, u.phone = ?5"+
            " where u.id = ?6")
    int updateUser(String firstName, String lastName, String email, String password, String phone, long id);
}
