package at.kaindorf.service.order;

import at.kaindorf.models.Order;
import at.kaindorf.models.Trip;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createOrder(Order order, Long tripId) throws Exception;
    Optional<Order> findOrderById(Long id);
    Optional<Order> findOrderByTrip(Long id);
    List<Order> getAllOrders();
    void delete(Order order);
    void deleteAll();
    void deleteOrderById(Long id);

}
