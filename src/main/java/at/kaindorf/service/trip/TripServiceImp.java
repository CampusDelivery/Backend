package at.kaindorf.service.trip;

import at.kaindorf.models.Trip;
import at.kaindorf.repositories.TripRepository;
import at.kaindorf.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripServiceImp implements TripService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    @Override
    public Trip createTrip(Trip trip) throws Exception {
        if(trip.getDestination().isEmpty() || trip.getTime() == null || trip.getMaxNumberOfOrders() == 0) throw new Exception("Missing Attribute");
        if(trip.getUser() == null){

        }

        return tripRepository.save(trip);
    }

    @Override
    public Optional<List<Trip>> getAllTrips() {
        return Optional.of(tripRepository.findAll());
    }

    @Override
    public Optional<Trip> getTripById(Long id) {
        return Optional.of(tripRepository.findById(id));
    }

    @Override
    public void delete(Trip trip) {
        tripRepository.delete(trip);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(Long id) {

    }
}
