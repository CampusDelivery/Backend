package at.kaindorf.service.order;

import at.kaindorf.models.Order;
import at.kaindorf.models.Trip;
import at.kaindorf.repositories.OrderRepository;
import at.kaindorf.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;
    private final TripRepository tripRepository;

    @Override
    public Order createOrder(Order order, Long tripId) throws Exception {
        if(order.getOrdererName().isEmpty()) throw new Exception("Missing Attribute");
        Optional<Trip> trip = tripRepository.findById(tripId);
        System.out.println(tripId);
        if(!trip.isPresent()) throw new Exception("Trip not found");
        order.setTrip(trip.get());
        return orderRepository.save(order);
    }


    @Override
    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Optional<Order> findOrderByTrip(Long id) {
        return orderRepository.findByTripId(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }

    @Override
    public void deleteOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()) orderRepository.delete(order.get());
    }
}
