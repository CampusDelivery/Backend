package at.kaindorf.controller;

import at.kaindorf.models.Order;
import at.kaindorf.models.Trip;
import at.kaindorf.repositories.OrderRepository;
import at.kaindorf.service.order.OrderService;
import at.kaindorf.service.order.OrderServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderServiceImp orderService;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) {
        Optional<Order> order = orderService.findOrderById(id);
        if(order.isPresent()) {
            return ResponseEntity.ok(order.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Order> createOrder(@RequestBody Order order, @RequestParam(name = "id", required = false) Long tripId) throws Exception {
        System.out.println(order);
        return ResponseEntity.ok(orderService.createOrder(order, tripId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTrip(@RequestBody Order order) {
        orderService.delete(order);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok().build();
    }
}
