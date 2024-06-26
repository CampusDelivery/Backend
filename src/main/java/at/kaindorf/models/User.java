package at.kaindorf.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @Column(unique = true, nullable = false, name = "UID(email)")
    private String email;

    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String password;

    @OneToMany(
            mappedBy = "user",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH},
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @JsonIgnore
    @ToString.Exclude
    private List<Trip> trips;


    public boolean addTrip(Trip trip) {
        if (trip == null) return false;
        trip.setUser(this);
        return trips.add(trip);
    }
}
