package at.kaindorf.controller;

import at.kaindorf.models.Article;
import at.kaindorf.models.Order;
import at.kaindorf.service.article.ArticleService;
import at.kaindorf.service.article.ArticleServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ArticleController {

    private final ArticleServiceImp articleService;

    @GetMapping("/all")
    public ResponseEntity<List<Article>> getAll() {
        List<Article> articles = articleService.findAllArticles();
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getById(@PathVariable Long id) {
        Optional<Article> article = articleService.findArticleById(id);
        if(article.isPresent()) {
            return ResponseEntity.ok(article.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) throws Exception {
        return ResponseEntity.ok(articleService.createArticle(article));
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addArticle(@RequestParam(name = "order", required = false) Long orderId,
                                            @RequestParam(name = "article", required = false) Long articleId) throws Exception {
        return ResponseEntity.ok(articleService.addArticle(articleId, orderId));
    }
    //article/add?order=1&article=3

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteArticle(@RequestBody Article article) {
        articleService.deleteArticle(article);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticleById(id);
        return ResponseEntity.ok().build();
    }

}
