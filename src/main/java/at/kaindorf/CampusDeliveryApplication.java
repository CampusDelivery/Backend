package at.kaindorf;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CampusDeliveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampusDeliveryApplication.class, args);
    }


    Faker faker = new Faker();


}
