package at.kaindorf.repositories;

import at.kaindorf.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TripRepository extends JpaRepository<Trip, Integer> {
    Trip findById(Long id);
}
