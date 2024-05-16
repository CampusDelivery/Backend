package at.kaindorf.service.user;

import at.kaindorf.models.Trip;
import at.kaindorf.models.User;
import at.kaindorf.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements  UserService{

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) throws Exception {
        if(user.getEmail().isEmpty() || user.getPassword().isEmpty() || user.getLastname().isEmpty() || user.getFirstname().isEmpty()) throw new Exception("Misssing Attribute");
        if(!userRepository.findByEmail(user.getEmail()).isEmpty()) throw new Exception("User already exists");
        if(user.getTrips() == null) user.setTrips(new ArrayList<>());
        return userRepository.save(user);
    }

    @Override
    public Optional<List<User>> getAllUsers() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }



    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteByEmail(String email) {
        Optional<User> find = userRepository.findByEmail(email);
        find.ifPresent(this::delete);
    }
}
