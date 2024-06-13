package at.kaindorf.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Trip {

    @Id
    @Column(
            name = "trip_id"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String destination;
    @Column(name = "Uhrzeit", nullable = false)
    private LocalTime time;
    @Column(nullable = false)
    private int maxNumberOfOrders;

    @ManyToOne(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH},
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    @JoinColumn(name = "user")
    private User user;

    @OneToMany(
            mappedBy = "trip",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH},
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @JsonIgnore
    @ToString.Exclude
    private List<Order> orders = new ArrayList<>();


    public boolean addOrder(Order order) {
        if (order == null) return false;
        order.setTrip(this);
        return orders.add(order);
    }
}
