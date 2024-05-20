package at.kaindorf;

import at.kaindorf.models.Article;
import at.kaindorf.models.Order;
import at.kaindorf.models.Trip;
import at.kaindorf.models.User;
import at.kaindorf.repositories.ArticleRepository;
import at.kaindorf.repositories.UserRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class CampusDeliveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampusDeliveryApplication.class, args);
    }


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    private final Faker faker = new Faker();

    @PostConstruct
    public void init() {

        User user1 = new User(faker.internet().emailAddress(), faker.name().firstName(), faker.name().lastName(), faker.internet().password(3,5), new ArrayList<>());
        User user2 = new User(faker.internet().emailAddress(), faker.name().firstName(), faker.name().lastName(), faker.internet().password(3,5), new ArrayList<>());
        User user3 = new User(faker.internet().emailAddress(), faker.name().firstName(), faker.name().lastName(), faker.internet().password(3,5), new ArrayList<>());

        Trip trip1 = new Trip(null, faker.address().cityName(), LocalDate.now(), faker.number().numberBetween(1,9),null , new ArrayList<>());
        Trip trip2 = new Trip(null, faker.address().cityName(), LocalDate.now(), faker.number().numberBetween(1,9),null , new ArrayList<>());
        Trip trip3 = new Trip(null, faker.address().cityName(), LocalDate.now(), faker.number().numberBetween(1,9),null , new ArrayList<>());

        Order order1 = new Order(null, faker.name().fullName(), null, new ArrayList<>());
        Order order2 = new Order(null, faker.name().fullName(), null, new ArrayList<>());
        Order order3 = new Order(null, faker.name().fullName(), null, new ArrayList<>());

        Article article1 = new Article(null, faker.food().dish(),  null);
        Article article2 = new Article(null, faker.food().dish(),  null);
        Article article3 = new Article(null, faker.food().dish(),  null);
        Article article4 = new Article(null, faker.food().dish(),  null);
        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);

        order1.setArticles(articles);

        trip1.addOrder(order1);
        trip1.addOrder(order2);
        trip1.addOrder(order3);

        user1.addTrip(trip1);
        user1.addTrip(trip2);
        user1.addTrip(trip3);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);


    }

}
