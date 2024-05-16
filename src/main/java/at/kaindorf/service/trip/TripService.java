package at.kaindorf.service.trip;

import at.kaindorf.models.Trip;

import java.util.List;
import java.util.Optional;

public interface TripService {

    Trip createTrip(Trip trip, String email) throws Exception;
    Optional<List<Trip>> getAllTrips();
    Optional<Trip> getTripById(Long id);
    void delete(Trip trip);
    void deleteAll();
    void deleteById(Long id);
}
