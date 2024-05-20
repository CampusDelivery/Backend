package at.kaindorf.repositories;

import at.kaindorf.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findById(Long id);
    Optional<Order> findByTripId(Long tripId);

}
