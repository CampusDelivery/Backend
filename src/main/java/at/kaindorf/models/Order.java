package at.kaindorf.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity(name = "realOrder")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(
            name = "order_id"
    )
    private Long id;

    @Column(nullable = false)
    private String OrdererName;

    @ManyToOne(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH},
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    @JoinColumn(name = "trip")
    private Trip trip;

    @ManyToMany(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "article_order",
            joinColumns = @JoinColumn(name = "OID"),
            inverseJoinColumns = @JoinColumn(name = "AID"))

    private List<Article> articles;

}
