package at.kaindorf.service.article;


import at.kaindorf.models.Article;
import at.kaindorf.models.Order;
import at.kaindorf.repositories.ArticleRepository;
import at.kaindorf.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImp implements ArticleService {

    private final ArticleRepository articleRepository;
    private final OrderRepository orderRepository;


    @Override
    public Article createArticle(Article article) throws Exception {
        if(article.getDescription().isEmpty()) throw new Exception("Missing Attribute");
        return articleRepository.save(article);
    }


    @Override
    public Order addArticle(Long articleId, Long id) throws Exception {
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent()) throw new Exception("Order not found");
        Optional<Article> article = articleRepository.findByArticleId(articleId);
        if(!article.isPresent()) throw new Exception("Article not found");
        order.get().getArticles().add(article.get());
        return orderRepository.save(order.get());
    }

    @Override
    public Optional<Article> findArticleById(Long id) {
        return articleRepository.findByArticleId(id);
    }

    @Override
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public void deleteArticleById(Long id) {
        Optional<Article> article = articleRepository.findByArticleId(id);
        articleRepository.delete(article.get());
    }

    @Override
    public void deleteAll() {
        articleRepository.deleteAll();
    }

    @Override
    public void deleteArticle(Article article) {
        articleRepository.delete(article);
    }
}
