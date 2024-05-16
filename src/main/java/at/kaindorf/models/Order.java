package at.kaindorf.models;

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

    @OneToMany(
            mappedBy = "order",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH},
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @ToString.Exclude
    private List<Article> articles;


    public boolean addArticle(Article article) {
        if (article == null) return false;
        article.setOrder(this);
        return articles.add(article);
    }
}
