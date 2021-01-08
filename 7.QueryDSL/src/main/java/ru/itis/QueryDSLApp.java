package ru.itis;

import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories(basePackages = "ru.itis.repository")
public class QueryDSLApp {
//
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(MongoClients.create(), "jaba");
//    }

    public static void main(String[] args) {
        SpringApplication.run(QueryDSLApp.class, args);
    }
}
