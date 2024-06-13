package at.kaindorf.repositories;

import at.kaindorf.models.Trip;
import at.kaindorf.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TripRepository extends JpaRepository<Trip, Integer> {
    Optional<Trip> findById(Long id);
    Optional<Trip> findByUserEmail(String email);
}
