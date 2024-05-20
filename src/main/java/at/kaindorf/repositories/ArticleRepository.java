package at.kaindorf.repositories;

import at.kaindorf.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findByArticleId(Long Id);
}
