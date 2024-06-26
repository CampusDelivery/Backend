package at.kaindorf.repositories;

import at.kaindorf.models.Trip;
import at.kaindorf.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findByTripsContains(Trip trip);
}
