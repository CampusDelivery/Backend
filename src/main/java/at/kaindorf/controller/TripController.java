package at.kaindorf.controller;

import at.kaindorf.models.Trip;
import at.kaindorf.service.trip.TripServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trip")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TripController {

    private final TripServiceImp tripServiceImp;

    @GetMapping("/all")
    public ResponseEntity<List<Trip>> getAllTrips() {
        Optional<List<Trip>> trips = tripServiceImp.getAllTrips();
        return ResponseEntity.ok(trips.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        Optional<Trip> trip = tripServiceImp.getTripById(id);
        if(trip.isPresent()) {
            return ResponseEntity.ok(trip.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip, @RequestParam(name = "email", required = false) String email) throws Exception {
        return ResponseEntity.ok(tripServiceImp.createTrip(trip, email));
    }
    // trip/new?email=preston.fisher@yahoo.com  --> Beispiel

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTrip(@RequestBody Trip trip) {
        tripServiceImp.delete(trip);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long id) {
        tripServiceImp.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
