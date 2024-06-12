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
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long articleId;

    @Column(nullable = false)
    private String description;


    @ManyToMany(
            mappedBy = "articles",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH},
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    @JsonIgnore
    private List<Order> orders;



}
