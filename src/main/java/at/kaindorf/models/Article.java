package at.kaindorf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @Column(nullable = false)
    private int count;

    @ManyToOne(
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH},
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            updatable = false,
            foreignKey = @ForeignKey(name = "article_order_fk")
    )
    private Order order;
}
