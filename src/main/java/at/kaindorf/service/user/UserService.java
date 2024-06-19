package at.kaindorf.service.user;

import at.kaindorf.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user) throws Exception;
    Optional<List<User>> getAllUsers();
    Optional<User> getUserByEmail(String email);
    void delete(User user);
    void deleteAll();
    void deleteByEmail(String email);


}
