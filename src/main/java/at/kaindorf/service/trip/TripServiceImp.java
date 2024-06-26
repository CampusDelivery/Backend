package at.kaindorf.service.trip;

import at.kaindorf.models.Trip;
import at.kaindorf.models.User;
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
    public Trip createTrip( Trip trip, String email) throws Exception {
        System.out.println(trip);
        System.out.println(email);
        if(trip.getDestination().isEmpty() || trip.getTime() == null || trip.getMaxNumberOfOrders() == 0) throw new Exception("Missing Attribute");
        Optional<User> user = userRepository.findByEmail(email);
        System.out.println("user: " + user);
        trip.setUser(user.get());
        return tripRepository.save(trip);
    }

    @Override
    public Optional<List<Trip>> getAllTrips() {
        return Optional.of(tripRepository.findAll());
    }

    @Override
    public Optional<Trip> getTripByUsername(String username) {
        Optional<User> user = userRepository.findByEmail(username);
        System.out.println(user.get()+"user");
        if(!user.isEmpty()) {
            System.out.println(tripRepository.findByUserEmail(user.get().getEmail())+"trip");
            return tripRepository.findByUserEmail(username);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
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
