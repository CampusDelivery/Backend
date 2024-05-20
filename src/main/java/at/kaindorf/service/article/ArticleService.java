package at.kaindorf.service.article;

import at.kaindorf.models.Article;
import at.kaindorf.models.Order;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    Article createArticle(Article article) throws Exception;
    Order addArticle(Long articleId, Long id) throws Exception;
    Optional<Article> findArticleById(Long id);
    List<Article> findAllArticles();
    void deleteArticleById(Long id);
    void deleteAll();
    void deleteArticle(Article article);

}
